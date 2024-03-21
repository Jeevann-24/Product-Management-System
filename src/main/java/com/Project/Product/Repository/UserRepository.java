package com.Project.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Product.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
