package com.example.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users") // User entity と Usersテーブルをつなげる
public class User {
	
	@OneToMany(mappedBy = "user")
	private List<Traffic> traffic;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動裁判
	private Long id;
	private String name;
	private String mail;
	private String password;
	private String role;
	private LocalDate createDate;
	private LocalDate updateDate;
	private LocalDate deleteDate;
	

	// 現在時刻取得機能
	public LocalDate getLocalDate() {
		return LocalDate.now();
	}
	
}


/* H2DB構築
create table Users (
	id identity primary key,
	name varchar(40) NOT NULL,
	mail varchar(80) NOT NULL,
	password varchar(60) NOT NULL,
	role char(1) NOT NULL,
	createdate timestamp,
	updatedate timestamp,
	deletedate timestamp
)

INSERT INTO Users( NAME, MAIL, PASSWORD, ROLE, CREATE_DATE, UPDATE_DATE, DELETE_DATE)
VALUES
('First Man', 'a@a', 'pass1', '1',  '2025-04-01', '2025-05-01', '2025-06-01'),
('Second Man', 'a@a', 'pass1', '1',  '2025-04-01', '2025-05-01', '2025-06-01');

INSERT INTO Users( NAME, MAIL, PASSWORD, ROLE)
VALUES
('First Man', 'a@a', 'pass1', '1'),
('Second Man', 'a@a', 'pass1', '1');

*/