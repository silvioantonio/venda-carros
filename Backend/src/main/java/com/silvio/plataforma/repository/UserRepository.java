package com.silvio.plataforma.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.silvio.plataforma.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	User findByUserName(String username);
}
