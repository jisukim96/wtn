package com.mysite.wtn.content.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubContentsController {

	@GetMapping("/movieContents")
	public String moviecontentsopen() {
		
		return "movieContents";
		
	}
	
	@GetMapping("/movie/detail/{id}")
	public String contentdetail(Model model,@PathVariable String id) {
		model.addAttribute("id", id);
		return "movieContents";
		
	}
	
	@GetMapping("/tvContents")
	public String tvcontentsopen() {
		
		return "tvContents";
		
	}
	
	@GetMapping("/tv/detail/{id}")
	public String tvcontentdetail(Model model,@PathVariable String id) {
		model.addAttribute("id", id);
		return "tvContents";
		
	}
	
	@GetMapping("/search")
	public String movieSearch() {
		
		return "search";
	}
}
