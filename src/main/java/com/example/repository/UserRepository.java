package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	// 削除していないユーザーの表示
	// @Query("SELECT u FROM User u WHERE u.deleteDate IS NULL")
	// List<User> getAllEmp();

}
