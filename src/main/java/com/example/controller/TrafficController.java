package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.details.UserDetailsImpl;
import com.example.entity.Traffic;
import com.example.form.TrafficForm;
import com.example.service.TrafficService;

import jakarta.validation.Valid;

@Controller
public class TrafficController {
	
	@Autowired 
	private TrafficService trafficService;
	
	private String view(String name) {
		return "public/traffic/" + name;
	}
	
	// 交通費一覧画面
	@GetMapping("index")
	public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		Long userId = userDetails.getUser().getId();
		
		List<Traffic> traffics = trafficService.getAllTraffics(userId);

		model.addAttribute("traffics", traffics);
		
		long totalCost = trafficService.sumCost(traffics);
		model.addAttribute("totalCost", totalCost);
		
		Map<Integer, String> monthMap = new LinkedHashMap<>();
		for(int i = 1; i <= 12; i++) {
			monthMap.put(i,  i + "月");
		}
		model.addAttribute("months", monthMap);
				
		return view("index");
	}
	
	// 交通費登録画面
	@GetMapping("new")
	public String newTraffic(Model model) {
		
		TrafficForm form = new TrafficForm();
		model.addAttribute("form", form);
		
		return view("new");
	}
	
	// 交通費登録処理
	@PostMapping("new")
	public String registerTrafficCosts(
			Model model,
			@Valid @ModelAttribute("form") TrafficForm form,
			BindingResult bindingResult) {		

		if(bindingResult.hasErrors()) {
			return view("new");
		}
		
		return view("new");
	}
}
