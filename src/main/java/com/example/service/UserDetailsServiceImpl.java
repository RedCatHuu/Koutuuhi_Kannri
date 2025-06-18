package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.details.UserDetailsImpl;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException{
		if(mail == null || "".equals(mail)) {
			throw new UsernameNotFoundException("メールアドレスが空です");
		}
		// DBからアカウント情報を取得する
		Optional<User> user = repo.findByMail(mail);
		return user.map(UserDetailsImpl::new)
			    .orElseThrow(() -> new UsernameNotFoundException(mail + " は見つかりません。"));

	}
}
