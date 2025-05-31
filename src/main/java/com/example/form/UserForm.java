package com.example.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
	private Long id;
	
	@NotEmpty(message="名前を入力してください")
	private String name;
	
	@Email(message = "有効なメールアドレスを入力してください")
	@NotEmpty(message="メールアドレスを入力してください")
	private String mail;
	
	@NotEmpty(message="パスワードを入力してください")
	@Size(min=4, max = 20, message="パスワードは4～20桁を入力してください")
	private String password;
	private String role;
	private LocalDate createDate;
	private LocalDate updateDate;
	private LocalDate deleteDate;
	
}

