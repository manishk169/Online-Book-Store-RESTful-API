package com.mk.bookstore.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.bookstore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	 User findByUsername(String username);
}
