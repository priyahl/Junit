package com.junit.Service;

import java.util.List;

import com.junit.dto.UserDto;

public interface UserService {

	public UserDto adduser(UserDto userDto);

	public UserDto getUserById(long id);

	public List<UserDto> getAllUser();
	
	public Object deleteuser(long id);

}
