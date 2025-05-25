package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
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

INSERT INTO Users( NAME, MAIL, PASSWORD, ROLE, CREATEDATE, UPDATEDATE, DELETEDATE)
VALUES('First Test', 'a@a', 'pass1', '1',  '2025-04-01', '2025-05-01', '2025-06-01');

*/