package com.example.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	// 削除していないユーザーの表示
	// @Query("SELECT u FROM User u WHERE u.deleteDate IS NULL")
	// List<User> getAllEmp();
	
	List<User> findByNameContaining(String name);
	Optional<User> findByMail(String mail);

}
