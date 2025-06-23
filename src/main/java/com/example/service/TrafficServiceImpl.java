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
	public List<Traffic> getAllTraffics(Long userid){
		List<Traffic> traffics = repo.getAllTraffics(userid);
		return traffics;
	}
	
	// データベースへの保存
	public void save(Traffic traffic) {
		repo.save(traffic);
	}
	
	// 月別に交通費取得
	public List<Traffic> findByMonthAndId(int month, Long userid){
		return repo.findByMonth(month, userid);
	}
	
	// 交通費の合計額計算
	public long sumCost(List<Traffic> traffics) {
		long total = 0;
		for(Traffic traffic : traffics) {
			total += traffic.getCost();
		}
		return total;
	}

}
