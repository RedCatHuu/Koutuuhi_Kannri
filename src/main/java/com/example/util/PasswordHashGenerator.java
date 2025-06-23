package com.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String pw = "adminda";
//		String pw = "publicda";
		String pw = "test90";
        String hashed = encoder.encode(pw);
        System.out.println(pw+ " : " + hashed);

	}

}
