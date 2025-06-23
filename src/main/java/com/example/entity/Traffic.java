package com.example.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Traffic {
	
	@ManyToOne
	@JsonIgnore // Jsonで再帰エラーを回避するため
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private Long trafficid;
	private LocalDate dateofuse;
	private String means;
	private String sector;
	private String road;
	private int cost;
}