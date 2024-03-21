package com.Project.Product.ServiceIMPL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Project.Product.Entity.User;
import com.Project.Product.Repository.UserRepository;
import com.Project.Product.Service.UserService;
import com.Project.Product.Utility.ResponseStructure;


@Service
public class UserServiceIMPL implements UserService{
	

	private UserRepository userrepository;
	
	public UserServiceIMPL(UserRepository userrepository, ResponseStructure<User> structure) {
		super();
		this.userrepository = userrepository;
		this.structure = structure;
	}

	private ResponseStructure<User> structure;

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User uniqueUser= userrepository.save(user);
		
		return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
				.setMessage("User Saved Succesfully")
				.setData(uniqueUser));
	}

	
}
