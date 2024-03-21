package com.Project.Product.Service;

import org.springframework.http.ResponseEntity;

import com.Project.Product.Entity.User;
import com.Project.Product.Utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

	
}
