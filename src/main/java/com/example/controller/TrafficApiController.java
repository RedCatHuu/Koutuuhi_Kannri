package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.details.UserDetailsImpl;
import com.example.entity.Traffic;
import com.example.service.TrafficService;

@RestController
@RequestMapping("/api")
public class TrafficApiController {

    @Autowired
    private TrafficService trafficService;

    @GetMapping("/traffic")
    public Map<String, Object> getTrafficByMonth(@RequestParam(required = false) Integer month, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    	Long userId = userDetails.getUser().getId();
    	List<Traffic> traffics = (month == null) ?
    							 trafficService.getAllTraffics(userId) :
								 trafficService.findByMonthAndId(month, userId);
    	
    	long total = trafficService.sumCost(traffics);
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("traffics", traffics);
    	response.put("totalCost", total);
    	
    	return response;
    	
    }
}

