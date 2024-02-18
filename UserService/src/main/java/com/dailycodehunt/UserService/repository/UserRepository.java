package com.dailycodehunt.UserService.repository;

import com.dailycodehunt.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
