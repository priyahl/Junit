package com.junit.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.junit.Repo.UserRepo;
import com.junit.Service.UserService;
import com.junit.dto.UserDto;
import com.junit.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;

	@Override
	public UserDto adduser(UserDto userDto) {

		User user = new User();

		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setRole(userDto.getRole());
		userRepo.save(user);
		
		UserDto userDto2 = new UserDto();
		userDto2.setId(user.getId());
		userDto2.setName(user.getName());
		userDto2.setRole(user.getRole());

		return userDto2;
	}

	@Override
	public List<UserDto> getAllUser() {

		List<User> user = userRepo.findAll();

		List<UserDto> allUser = new ArrayList<>();

		for (User savedUser : user) {

			UserDto userDTO = new UserDto();

			userDTO.setId(savedUser.getId());
			userDTO.setName(savedUser.getName());
			userDTO.setRole(savedUser.getRole());

			allUser.add(userDTO);
		}
		System.out.println("getting data from db:" + user);

		return allUser;
	}

	@Override
	public UserDto getUserById(long id) {

		UserDto udto = new UserDto();

		User user1 = userRepo.findById(id);
		if (user1 != null) {

			udto.setId(user1.getId());
			udto.setName(user1.getName());
			udto.setRole(user1.getRole());

			return udto;
		} else
			throw new RuntimeException("User Id is not present.");
	}

	@Override
	public Object deleteuser(long id) {
		 User user = userRepo.findById(id);
		    if (user != null) {
		    	userRepo.delete(user);
		        UserDto deletedDto = new UserDto();
		        deletedDto.setId(user.getId());
		     
		        // Set other fields as needed
		        return "deleted successfully";
		    } else {
		        throw new RuntimeException("user with ID " + id + " not found.");
		    }
	}
}
