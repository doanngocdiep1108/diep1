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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dto.BDSDTO;
import com.poly.model.BDS;
import com.poly.services.BDSImageService;
import com.poly.services.BDSService;

@Controller
@RequestMapping("/bds")
public class BDSController {
	@Autowired
	BDSService bdsService;

	@Autowired
	BDSImageService bdsImageService;

	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		BDSDTO dto = new BDSDTO();
		model.addAttribute("BDSDTO", dto);
		model.addAttribute("ACTION", "/bds/saveOrUpdate");
		return "bds";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("BDSDTO") BDSDTO dto) {
		Optional<BDS> optionalbds = bdsService.findById(dto.getId());
		BDS bds = null;
		String img = "demo.jpg";
		if (optionalbds.isPresent()) {
			// save
			if (dto.getImage().isEmpty()) {
				img = optionalbds.get().getImage();
			} else {
				try {
					FileCopyUtils.copy(dto.getImage().getInputStream(),
							new FileOutputStream(new File("imgUploads/", dto.getImage().getOriginalFilename())));
					img = dto.getImage().getOriginalFilename().toString();
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
					img = dto.getImage().getOriginalFilename().toString();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		bds = new BDS(dto.getId(), dto.getName(), dto.getAddress(), dto.getDistrict(), dto.getCity(), dto.getPrice(),
				dto.getS(), dto.getPeople(), dto.getTime(), dto.getPhone(), dto.getNote(), dto.getType(), img);
		bdsService.save(bds);
		return "bds";
	}

	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		model.addAttribute("BDS", bdsService.findAllByOrderByTimeDesc());
		return "listBDS";
	}

	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<BDS> optionalbds = bdsService.findById(id);
		BDSDTO dto = null;
		if (optionalbds.isPresent()) {
			BDS bds = optionalbds.get();
			File file = new File("imgUploads/" + bds.getImage());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multifile = new MockMultipartFile("file", file.getName(), "text/plain",
						IOUtils.toByteArray(input));
				dto = new BDSDTO(bds.getId(), bds.getName(), bds.getAddress(), bds.getDistrict(), bds.getCity(),
						bds.getPrice(), bds.getS(), bds.getPeople(), bds.getTime(), bds.getPhone(), bds.getNote(),
						bds.getType(), multifile);
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			model.addAttribute("BDSDTO", dto);
		} else {
			model.addAttribute("BDSDTO", new BDSDTO());
		}

		model.addAttribute("ACTION", "/bds/saveOrUpdate");
		return "bds";
	}

	@RequestMapping(value = "/getimg/{photo}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
		if (!photo.equals("") || photo != null) {
			try {
				Path filename = Paths.get("imgUploads", photo);
				byte[] buffer = Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/jpg")).body(byteArrayResource);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ResponseEntity.badRequest().build();
	}

	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		bdsService.deleteById(id);
		model.addAttribute("BDS", bdsService.findAll());
		return "listBDS";
	}

	@RequestMapping("/find")
	public String search(ModelMap model, @RequestParam() String id, @RequestParam(defaultValue = "") String name,
			@RequestParam() String type, @RequestParam() String s, @RequestParam() String price) {

//		List<BDS> list = bdsService.findByIdStartingWithAndNameLikeAndTypeLike(id, name, type);
//		model.addAttribute("BDS", list);

		List<BDS> list = bdsService.findByIdStartingWithAndNameLikeAndTypeLikeAndSLessThanEqualAndPriceLessThanEqual(id,
				name, type, Integer.parseInt(s), Float.parseFloat(price));
		model.addAttribute("BDS", list);
		return "listBDS";
	}
	
}
