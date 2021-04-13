package com.poly.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.model.BDS;
import com.poly.model.BDSImage;
import com.poly.services.BDSImageService;
import com.poly.services.BDSService;

@Controller
public class ViewController {
	
	@Autowired
	BDSService bdsService;
	
	@Autowired
	BDSImageService bdsImageService;
	
	@RequestMapping(value={"/","/trangchu"})
	public String showHome(ModelMap model) {
		model.addAttribute("BDS", bdsService.findTop10ByOrderByTimeDesc());
		return "home";
	}
	
	@RequestMapping("/hoidap")
	public String showHoiDap() {
		return "hoidap";
	}
	@RequestMapping("/qchd")
	public String showQCHD() {
		return "quychehd";
	}
	@RequestMapping("/gioithieu")
	public String showGioiThieu() {
		return "gioithieu";
	}
	
	@RequestMapping("/bantin")
	public String listBanTin(ModelMap model) {
		model.addAttribute("BDS", bdsService.findAllByOrderByTimeDesc());
		model.addAttribute("BDS1",bdsService.findTop3ByOrderByTimeDesc());
		return "bantin";
	}
	
	@RequestMapping("/chitiet/{id}")
	public String list(ModelMap model,  @PathVariable(name="id") String id ) {
		System.out.println(id);
		Optional<BDS> bdsct = bdsService.findById(id);
		if (bdsct.isPresent()) {
			BDS bds = bdsct.get();
			model.addAttribute("BDS", bds);
		}
		model.addAttribute("IMAGE", bdsImageService.findAllByBds_id(id));
		return "ctbds";
	}
	
	@RequestMapping("/find")
	public String search(ModelMap model, @RequestParam() String id, @RequestParam(defaultValue = "") String name,
			@RequestParam() String type, @RequestParam() String s, @RequestParam() String price) {
		List<BDS> list = bdsService.findByIdStartingWithAndNameLikeAndTypeLikeAndSLessThanEqualAndPriceLessThanEqual(id,
				name, type, Integer.parseInt(s), Float.parseFloat(price));
		model.addAttribute("BDS", list);
		return "bantin";
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
	
	
}
