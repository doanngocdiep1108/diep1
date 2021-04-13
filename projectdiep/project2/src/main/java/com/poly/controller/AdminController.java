package com.poly.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.model.Admin;
import com.poly.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		Admin ad = new Admin();
		model.addAttribute("ADMIN", ad);
		model.addAttribute("ACTION", "/admin/saveOrUpdate");
		return "admin";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("ADMIN") Admin ad) {
		adminService.save(ad);
		return "admin";
	}

	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		model.addAttribute("ADMIN",adminService.findAll());
		return "listAdmin";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Admin> ad = adminService.findById(id);
		if (ad.isPresent()) {
			model.addAttribute("ADMIN", ad.get());
		} else {
			model.addAttribute("ADMIN", new Admin());
		}

		model.addAttribute("ACTION", "/admin/saveOrUpdate");
		return "admin";
	}

	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		adminService.deleteById(id);
		model.addAttribute("ADMIN", adminService.findAll());
		return "listAdmin";
	}

	@RequestMapping("/find")
	public String search(ModelMap model, @RequestParam(defaultValue="") String search) {
		List<Admin> list = adminService.findByFullnameLikeOrderByFullname(search);
		model.addAttribute("ADMIN", list);
		return "listAdmin";
	}
}
