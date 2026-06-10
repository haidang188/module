package com.haidang.validateregister.repository;

import com.haidang.validateregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User, Long> {
}
