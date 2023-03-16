package com.mysite.wtn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests().requestMatchers(
				
				//Spring Security 에서 모든 URL에서 인증없이 접근할 수 있도록 허용함
                new AntPathRequestMatcher("/**")).permitAll()
			//H2-DataBase는 http로 통신하는 DataVase이므로 csrf 적용되지 않도록 설정
			.and()	//http 객체의 설정을 이어서 할 수 있게 하는 메소드
				.csrf().ignoringRequestMatchers( //
						new AntPathRequestMatcher("/h2-console/**")) ///h2-console/로 시작하는 URL은 CSRF 검증을 하지 않는다는 설정
			.and()
				.headers()
				.addHeaderWriter(new XFrameOptionsHeaderWriter(
						XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
			//Spring Security 로그인 처리부분
			.and()
				.formLogin()
				.loginPage("/user/login")
				.defaultSuccessUrl("/")		//로그인 성공 시 세션에 로그인 정보를 담고 '/'페이지로 이동
			
			//Spring Security 로그아웃 처리부분
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)	//세션에 담긴 모든 값을 삭제
				;
        return http.build();
	}
	@Bean		//패스워드 해쉬코드로 변환하여 보안
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
