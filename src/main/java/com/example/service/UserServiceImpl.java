package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;
	
	// 全社員取得
	public List<User> getAllEmp(){
		List<User> users = repo.getAllEmp();
		return users;
	}
	
	
	// データベースへの保存
	public void save(User user) {
		repo.save(user);
	}

}
