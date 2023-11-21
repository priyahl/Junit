package com.junit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findById(long id);
}
