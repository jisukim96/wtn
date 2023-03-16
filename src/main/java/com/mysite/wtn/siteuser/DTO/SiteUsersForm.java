package com.mysite.wtn.siteuser.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteUsersForm {
	
	@NotEmpty(message = "이메일을 입력하세요.")
	@Email
	@Size(min = 11 ,max = 30)
	private String userId;
	
	@NotEmpty(message = "닉네임을 입력하세요.")
	private String name;
	
	@NotEmpty(message = "비밀번호를 입력하세요.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String pass1;
	
	private String pass2;
	   
	
}
