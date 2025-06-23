package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Traffic;

public interface TrafficRepository extends JpaRepository<Traffic, Long>{
	
	@Query("SELECT t FROM Traffic t WHERE t.user.id = :userid")
	List<Traffic> getAllTraffics(@Param("userid") Long userid);
	
	@Query("SELECT t FROM Traffic t WHERE MONTH(t.dateofuse) = :month AND t.user.id = :userid")
	List<Traffic> findByMonth(@Param("month") int month, @Param("userid") Long userid);

}
