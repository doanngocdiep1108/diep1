package com.poly.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dto.ImageDTO;
import com.poly.model.BDS;
import com.poly.model.BDSImage;
import com.poly.services.BDSImageService;

@Controller
@RequestMapping("/img")
public class ImageController {

	@Autowired
	BDSImageService bdsImageService;
	
	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		ImageDTO dto = new ImageDTO();
		model.addAttribute("IMGDTO", dto);
		model.addAttribute("ACTION", "/img/saveOrUpdate");
		return "images";
	}

	@ModelAttribute(name = "BDS")
	public List<BDS> getAllBDS() {
		return bdsImageService.findAllBDS();
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("IMGDTO") ImageDTO dto) {
		Optional<BDSImage> optional = bdsImageService.findById(dto.getId());
		BDSImage bdsimg = null;
		String images = "demo.jpg";
		if (optional.isPresent()) {
			// save
			if (dto.getImage().isEmpty()) {
				images = optional.get().getImage();
			} else {
				try {
					FileCopyUtils.copy(dto.getImage().getInputStream(),
							new FileOutputStream(new File("imgUploads/", dto.getImage().getOriginalFilename())));
					images = dto.getImage().getOriginalFilename().toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			// new
			if (!dto.getImage().isEmpty()) {
				try {
					FileCopyUtils.copy(dto.getImage().getInputStream(),
							new FileOutputStream(new File("imgUploads/", dto.getImage().getOriginalFilename())));
					
					images = dto.getImage().getOriginalFilename().toString();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		bdsimg = new BDSImage(dto.getId(), images, new BDS(dto.getBds_id()));
		bdsImageService.save(bdsimg);
		return "images";
	}

	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		model.addAttribute("IMAGE", bdsImageService.findAll());
		return "listImage";
	}

	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") int id) {
		Optional<BDSImage> optionalimg = bdsImageService.findById(id);
		ImageDTO dto = null;
		if (optionalimg.isPresent()) {
			BDSImage img = optionalimg.get();
			File file = new File("imgUploads/" + img.getImage());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multifile = new MockMultipartFile("file", file.getName(), "text/plain",
						IOUtils.toByteArray(input));
				dto = new ImageDTO(img.getId(), multifile, img.getBds().getId());

			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			model.addAttribute("IMGDTO", dto);
		} else {
			model.addAttribute("IMGDTO", new ImageDTO());
		}

		model.addAttribute("ACTION", "/img/saveOrUpdate");
		return "images";
	}

	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") int id) {
		bdsImageService.deleteById(id);
		model.addAttribute("IMAGE", bdsImageService.findAll());
		return "listImage";
	}
	
	@RequestMapping(value = "/getimg/{photo}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo){
		if(!photo.equals("")||photo!=null) {
			try {
				Path filename = Paths.get("imgUploads",photo);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/jpg"))
						.body(byteArrayResource);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
}
