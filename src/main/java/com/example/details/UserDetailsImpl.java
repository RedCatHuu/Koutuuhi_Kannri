package com.example.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;

// リファレンス
// https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/UserDetails.html

public class UserDetailsImpl implements UserDetails {
	private User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return AuthorityUtils.createAuthorityList("ROLE_" + user.getRoleName());
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return user.getName();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public User getUser() {
		return user;
	}
	
	public String getName() {
		return user.getName();
	}
	
	
}
