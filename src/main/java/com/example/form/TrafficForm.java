package com.example.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TrafficForm {
	private Long trafficid;
		
	@NotNull(message="利用日を選択してください")
	private LocalDate dateofuse;
	
	@NotEmpty(message="利用機関を入力してください")
	private String means;
	
	@NotEmpty(message="利用区間を入力してください")
	private String sector;
	
	@NotEmpty(message="往復・片道を入力してください")
	private String road;
	
	@NotEmpty(message="交通費を入力してください")
	private String cost;
	
	// 交通費一覧画面の月選択用フィールド
	private Integer month;
	
}

