package com.mysite.wtn.siteuser.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.wtn.siteuser.UserService;
import com.mysite.wtn.siteuser.DTO.SiteUsersForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SiteUsersController {

	private final UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user/inroll")
	public String open(SiteUsersForm siteUsersForm) {
		return "join";
	}
	
	@PostMapping("/user/inroll")
	public String inrollUser(@Valid SiteUsersForm siteUsersForm, BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			System.out.println("바인딩 리절트 오류");
			return "join";
		}
		
		if(!siteUsersForm.getPass1().equals(siteUsersForm.getPass2())) {
			System.out.println("비밀번호 불일치");
			bindingResult.rejectValue("pass2", "passwordIncorect", "비밀번호 불일치");
			return "join";
		}
		
		try {
				userService.saveUser(siteUsersForm.getUserId(), siteUsersForm.getPass1(), siteUsersForm.getName());
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("joinFailed","이미 등록된 사용자입니다.");
				return "join";
		}catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("joinFailed",e.getMessage());
			return "join";
		}
		return "redirect:/";
	}
	
	
	
}
