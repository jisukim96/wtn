package com.mysite.wtn.siteuser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200 , unique = true)
	private String userId; 
	
	@Column(length = 200)
	private String name;
	
	@Column(length = 200)
	private String pass;
	
	
	
}
