package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Traffic;
import com.example.service.TrafficService;

@Controller
public class TrafficController {
	
	@Autowired 
	private TrafficService trafficService;
	
	private String view(String name) {
		return "public/traffic/" + name;
	}
	
	// 交通費一覧画面
	@GetMapping("index")
	public String index(Model model) {
		
		List<Traffic> traffics = trafficService.getAllTravelCosts();
		model.addAttribute("traffics", traffics);
		
		return view("index");
	}
}
