package com.junit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junit.Service.UserService;
import com.junit.dto.UserDto;


@RestController
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/add")
	public UserDto adduser(@RequestBody UserDto userDto) {
		return userService.adduser(userDto);
	}

	@GetMapping("/getAlluser")
	public List<UserDto> getAllUser() {
		return userService.getAllUser();
	}
	 @GetMapping("/getuserById/{id}")
	    public UserDto getUserById(@PathVariable long id) {
	    	return userService.getUserById(id);
	    }
	 @DeleteMapping("/deleteuser/{id}")
		public Object deleteuser(@PathVariable long id) {
			return userService.deleteuser(id);
		}
}
