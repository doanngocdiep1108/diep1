package com.poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.services.AdminService;
import com.poly.services.BDSService;
import com.poly.services.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BDSService bdsService;
	
	@RequestMapping("/login")
	public String showLogin() {

		return "login";
	}
//	@RequestMapping("/qmk")
//	public String showQuenmk(ModelMap model, @RequestParam("id") String id, HttpSession session) {
//		if (adminService.checkLogin(id)) {
//			session.setAttribute("ID", id);
//			model.addAttribute("ERROR", );
//		}else if (userService.checkLogin(id)) {
//			session.setAttribute("ID", id);
//			model.addAttribute("ERROR", "Username not exist");
//		} else {
//			model.addAttribute("ERROR", "Username not exist");
//		}
//		return "quenmk";
//	}

	@RequestMapping("/checkLogin")
	public String checkLogin(ModelMap model, @RequestParam("id") String id, @RequestParam("password") String password,
			HttpSession session) {

		if (adminService.checkLogin(id, password)) {
			System.out.println("admin login");
			session.setAttribute("ID", id);
			model.addAttribute("BDS", bdsService.findAll());
			return "listBDS";
		}else if (userService.checkLogin(id, password)) {
			System.out.println("users login");
			session.setAttribute("ID", id);
			return "home";
		} else {
			System.out.println("Login that bai");
			model.addAttribute("ERROR", "Username or password not exist");
		}
		return "login";
	}

	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("ID");
		return "login";
	}
}
