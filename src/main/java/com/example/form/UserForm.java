package com.example.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserForm {
	private Long id;
	private String name;
	private String mail;
	private String password;
	private String role;
	private LocalDate createDate;
	private LocalDate updateDate;
	private LocalDate deleteDate;
}
