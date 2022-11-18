package com.spring.api.validation.repository;

import com.spring.api.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Integer> {
    User findByUserId(int id);
}
