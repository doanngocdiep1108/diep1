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

import com.poly.model.Users;
import com.poly.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		Users u = new Users();
		model.addAttribute("USERS", u);
		model.addAttribute("ACTION", "/users/saveOrUpdate");
		return "users";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USERS") Users u) {
		userService.save(u);
		return "users";
	}

	@RequestMapping("/list")
	public String list(ModelMap model, HttpSession session) {
		model.addAttribute("USERS",userService.findAll());
		return "listUsers";
	}

	@RequestMapping("/edit/{email}")
	public String edit(ModelMap model, @PathVariable(name = "email") String email) {
		Optional<Users> u = userService.findById(email);
		if (u.isPresent()) {
			model.addAttribute("USERS", u.get());
		} else {
			model.addAttribute("USERS", new Users());
		}

		model.addAttribute("ACTION", "/users/saveOrUpdate");
		return "users";
	}

	@RequestMapping("/delete/{email}")
	public String delete(ModelMap model, @PathVariable(name = "email") String email) {
		userService.deleteById(email);
		model.addAttribute("USERS", userService.findAll());
		return "listUsers";
	}
	@RequestMapping("/find")
	public String search(ModelMap model, @RequestParam(defaultValue="") String search) {
		List<Users> list = userService.findByFullnameLikeOrderByFullname(search);
		model.addAttribute("USERS", list);
		return "listUsers";
	}
}
