//package com.example.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.example.details.UserDetailsImpl;
//import com.example.entity.User;
//import com.example.repository.UserRepository;
//
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//	
//	@Autowired
//	private UserRepository repo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
//		if(userName == null || "".equals(userName)) {
//			throw new UsernameNotFoundException("ユーザー名が空です");
//		}
//		// DBからアカウント情報を取得する
//		User user = repo.findByName(userName);
//		if (user != null) {
//			return new UserDetailsImpl(user);
//		}
//		throw new UsernameNotFoundException(userName + "は見つかりませんでした。");
//	}
//}
