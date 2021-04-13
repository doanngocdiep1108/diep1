package com.poly.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dto.HDDTO;
import com.poly.model.QLHopDong;
import com.poly.model.Users;
import com.poly.services.HDService;

@Controller
@RequestMapping("/hd")
public class HDController {

	@Autowired
	HDService hdService;

	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		HDDTO hd = new HDDTO();
		model.addAttribute("HDDTO", hd);
		model.addAttribute("ACTION", "/hd/saveOrUpdate");
		return "qlhd";
	}

	@ModelAttribute(name = "USERS")
	public List<Users> getAllUsers() {
		return hdService.findAllUsers();
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("HDDTO") HDDTO dto) {
		Optional<QLHopDong> optionalhd = hdService.findById(dto.getId());
		QLHopDong hd = null;
		String files = "hd1.pdf";
		if (optionalhd.isPresent()) {
			// save
			if (dto.getFiles().isEmpty()) {
				files = optionalhd.get().getFiles();
			} else {
				try {
					FileCopyUtils.copy(dto.getFiles().getInputStream(),
							new FileOutputStream(new File("uploads/", dto.getFiles().getOriginalFilename())));
					files = dto.getFiles().getOriginalFilename().toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			// new
			if (!dto.getFiles().isEmpty()) {
				try {
					FileCopyUtils.copy(dto.getFiles().getInputStream(),
							new FileOutputStream(new File("uploads/", dto.getFiles().getOriginalFilename())));
					files = dto.getFiles().getOriginalFilename().toString();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		hd = new QLHopDong(dto.getId(), dto.getTime(), files, dto.isType(), new Users(dto.getEmail_user()));
		hdService.save(hd);
		return "qlhd";
	}

	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		model.addAttribute("QLHD", hdService.findAll());
		return "listHD";
	}

	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<QLHopDong> hd = hdService.findById(id);
		HDDTO dto = null;
		if (hd.isPresent()) {
			QLHopDong qlhd = hd.get();
			File file = new File("uploads/" + qlhd.getFiles());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multifile = new MockMultipartFile("file", file.getName(), "text/plain",
						IOUtils.toByteArray(input));
				dto = new HDDTO(qlhd.getId(), qlhd.getTime(), multifile, qlhd.isType(), qlhd.getUsers().getEmail());

			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			model.addAttribute("HDDTO", dto);
		} else {
			model.addAttribute("HDDTO", new HDDTO());
		}

		model.addAttribute("ACTION", "/hd/saveOrUpdate");
		return "qlhd";
	}

	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		hdService.deleteById(id);
		model.addAttribute("QLHD", hdService.findAll());
		return "listHD";
	}
	@RequestMapping("/find")
	public String search(ModelMap model, @RequestParam(defaultValue="") String search) {
		List<QLHopDong> list = hdService.findByFilesLikeOrderByFiles(search);
		model.addAttribute("QLHD", list);
		return "listHD";
	}
}
