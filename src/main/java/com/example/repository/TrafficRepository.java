package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Traffic;

public interface TrafficRepository extends JpaRepository<Traffic, Long>{
	

}
