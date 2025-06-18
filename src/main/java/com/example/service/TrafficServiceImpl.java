package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Traffic;
import com.example.repository.TrafficRepository;

@Service
public class TrafficServiceImpl implements TrafficService{
	
	@Autowired
	TrafficRepository repo;
	
	// 全交通費取得
	public List<Traffic> getAllTravelCosts(){
		List<Traffic> traffics = repo.findAll();
		return traffics;
	}
	
	// データベースへの保存
	public void save(Traffic traffic) {
		repo.save(traffic);
	}

}
