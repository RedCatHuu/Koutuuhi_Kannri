package com.example.service;

import java.util.List;

import com.example.entity.Traffic;


public interface TrafficService {
	List<Traffic> getAllTraffics(Long userid);
	void save(Traffic traffic);
	public List<Traffic> findByMonthAndId(int month, Long userid);
	public long sumCost(List<Traffic> traffics);

}
