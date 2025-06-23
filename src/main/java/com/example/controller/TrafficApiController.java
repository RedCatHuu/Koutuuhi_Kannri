package com.example.controller;

import java.util.List;

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
    public List<Traffic> getTrafficByMonth(@RequestParam(required = false) Integer month, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    	Long userId = userDetails.getUser().getId();
        if (month == null) {
            return trafficService.getAllTraffics(userId);
        }
        return trafficService.findByMonthAndId(month, userId); 
    }
}

