package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Traffic {
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動裁判
	private Long id;
	private LocalDate useday;
	private String means;
	private String sector;
	private String road;
	private int cost;
}

/* H2DB構築
create table Traffic (
	trafficid identity primary key,
	useday date NOT NULL,
	means varchar(255) NOT NULL,
	sector varchar(255) NOT NULL,
	road char(1) NOT NULL,
	cost int NOT NULL
)

INSERT INTO Traffic(USER_ID, USEDAY, MEANS, SECTOR, ROAD, COST)
	VALUES
	('1', '20250401', '通勤', '渋谷から新宿', '1', '300'),
	('1', '20250401', '通勤', '渋谷から新宿', '1', '300'),
	('1', '20250401', '通勤', '渋谷から新宿', '1', '300'),
	('1', '20250401', '通勤', '渋谷から新宿', '1', '300'),
	('2', '20250401', '通勤', '渋谷から新宿', '1', '300'),
	('2', '20250401', '通勤', '渋谷から新宿', '1', '300');

*/