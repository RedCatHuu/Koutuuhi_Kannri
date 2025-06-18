package com.example.service;

import java.util.List;

import com.example.entity.Traffic;


public interface TrafficService {
	List<Traffic> getAllTravelCosts();
	void save(Traffic traffic);
	

}
