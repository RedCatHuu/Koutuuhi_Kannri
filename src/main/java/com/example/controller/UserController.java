package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.form.UserForm;
import com.example.service.UserService;

import jakarta.validation.Valid;

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
		public String registerUser(
				Model model,
				@Valid @ModelAttribute("userForm") UserForm userForm,
				BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
				return "user/new";
			}
			
			User user = new User();
			user.setName(userForm.getName());
			user.setMail(userForm.getMail());
			user.setPassword(userForm.getPassword());			
			user.setCreateDate(LocalDate.now());
			userService.save(user);
			
			List<User> users = userService.getAllEmp();
			model.addAttribute("users", users);
					
			return "user/index";			
		}
		
		// 社員更新画面
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable Long id, Model model) {
			
			
			User user = userService.findById(id);
			UserForm form = new UserForm();
			form.setId(user.getId());
			form.setName(user.getName());
			form.setMail(user.getMail());
			form.setPassword("dummy");
			model.addAttribute("form", form);
			
			return "user/edit";
		}
		
		// 社員更新処理
		@PostMapping("/update")
		public String update( 
				Model model,
				@Valid @ModelAttribute("form") UserForm form,
				BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
				return "user/edit";
			}
			
			User user = userService.findById(form.getId());
			user.setName(form.getName());
			user.setMail(form.getMail());
			userService.save(user);
			
			return "redirect:/";
		}

}
