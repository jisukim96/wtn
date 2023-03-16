package com.mysite.wtn.siteuser;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.wtn.siteuser.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder pE;
	
	
	
    public void saveUser( String userId , String pass , String name ) {
    	
    	SiteUsers siteUser = new SiteUsers();
    	siteUser.setUserId(userId);
    	siteUser.setPass(this.pE.encode(pass));
    	siteUser.setName(name);
    	
    	this.userRepository.save(siteUser);
    	
    }
	
}
