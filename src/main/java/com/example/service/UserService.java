package com.example.service;

import java.util.List;

import com.example.entity.User;


public interface UserService {
	List<User> getAllEmp();
	void save(User user);
	User findById(Long id);
}
