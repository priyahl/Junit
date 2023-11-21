package com.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.junit.Repo.UserRepo;
import com.junit.ServiceImpl.UserServiceImpl;
import com.junit.dto.UserDto;
import com.junit.model.User;

@SpringBootTest
class Junit1ApplicationTests {

	@Autowired
	private UserServiceImpl service;

	@MockBean
	private UserRepo repo;

	@Test
	public void getAllUserTest() {
		when(repo.findAll())
				.thenReturn(Stream.of(new User(1, "priya", "user"), new User(2, "savi", "admin"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getAllUser().size());
	}
	@Test
	public void getUserByIdTest() {
		long id = 1;
		User user = new User(1, "priya", "user");
		when(repo.findById(id))
				.thenReturn(new User(1, "priya", "user"));
		assertEquals(user.toString(), service.getUserById(id).toString());
	}
	@Test
	public void saveUserTest() {
		
		UserDto userDto = new UserDto(1,"darshu","admin");
		
		assertEquals(userDto.toString(),  service.adduser(userDto).toString());	}

	@Test
	public void deleteUserTest() {
		
		User user = new User(1, "priya", "user");
		when(repo.findById(1)).thenReturn(user);
		service.deleteuser(1);
		
		verify(repo, times(1)).delete(user);	
		
	}
}
