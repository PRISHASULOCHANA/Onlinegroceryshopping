package com.grocery.shopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.shopping.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
