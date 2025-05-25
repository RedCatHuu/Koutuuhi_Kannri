package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.form.UserForm;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private UserRepository repo;
	
	// 社員一覧画面
		@GetMapping("/")
		public String index(Model model) {
			List<User> users = userService.getAllEmp();
			// List<User> users = repo.findAll();
			model.addAttribute("users", users);
			System.out.println(users);
			return "user/index";
		}
	
	// 社員登録画面
		@GetMapping("/new")
		public String post(Model model) {
			
			UserForm userForm = new UserForm();
			model.addAttribute("userForm", userForm);
			
			return "user/new";
		}
		

		// 社員登録処理画面
		@PostMapping("/new")
		// viewで入力された新規userの情報がuserFormに渡される
		public String registerUser(UserForm userForm, Model model) {
			
			User user = new User();
			user.setName(userForm.getName());
			user.setMail(userForm.getMail());
			user.setPassword(userForm.getPassword());			
			user.setCreateDate(user.getLocalDate());
			userService.save(user);
			
			List<User> users = userService.getAllEmp();
			model.addAttribute("users", users);
					
			return "user/index";		
			
		}

}
