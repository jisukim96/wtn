package com.mysite.wtn.siteuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.wtn.siteuser.SiteUsers;

public interface UserRepository extends JpaRepository<SiteUsers, Integer> {

	Optional <SiteUsers> findByUserId(String userId);
	
}
