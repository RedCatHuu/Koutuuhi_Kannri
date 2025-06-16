package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasRole('ADMIN')") // adminロールを持つユーザーのみアクセス可
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private UserRepository repo;
	
	// 社員一覧画面
		@GetMapping("/index")
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
			model.addAttribute("form", userForm);
			
			return "user/new";
		}
		

		// 社員登録処理画面
		@PostMapping("/new")
		// viewで入力された新規userの情報がuserFormに渡される
		public String registerUser(
				Model model,
				@Valid @ModelAttribute("form") UserForm form,
				BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
				return "user/new";
			}
			
			User user = new User();
			user.setName(form.getName());
			user.setMail(form.getMail());
			user.setPassword(form.getPassword());			
			user.setCreateDate(user.getNow());
			user.setRole(form.getRole());
			userService.save(user);
			
			List<User> users = userService.getAllEmp();
			model.addAttribute("users", users);
			
			System.out.print(user);
					
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
			form.setRole(user.getRole());
			form.setDeleteDate(user.getDeleteDate());
			model.addAttribute("form", form);
			
			System.out.print(form);
			
			return "user/edit";
		}
		
		// 社員更新処理
		@PostMapping(value="/update", params="update")
		public String updateUser( 
				Model model,
				@Valid @ModelAttribute("form") UserForm form,
				BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
				return "user/edit";
			}
			
			User user = userService.findById(form.getId());
			user.setName(form.getName());
			user.setMail(form.getMail());
			user.setRole(form.getRole());			
			user.setUpdateDate(user.getNow());
			userService.save(user);
			
			System.out.print(user);
			
			return "redirect:/index";
		}
		
		// 社員削除処理
		// 更新も削除もpath名が同じなのが気になる
		@PostMapping(value="/update", params="delete")
		// public String deleteUser(@PathVariable Long id) {
		public String deleteUser(UserForm form) {
			User user = userService.findById(form.getId());			
			user.setDeleteDate(user.getNow());			
			userService.save(user);
			System.out.print(user);
			return "redirect:/index";
		}
		
		// 社員削除撤回処理
		@PostMapping(value="/update", params="undelete")
		public String undeleteUser(UserForm form) {
			User user = userService.findById(form.getId());
			user.setDeleteDate(null);
			userService.save(user);
			System.out.print(user);
			return "redirect:/index";
		}

}
