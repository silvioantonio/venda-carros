package com.silvio.plataforma.repository;

import org.springframework.data.repository.CrudRepository;

import com.silvio.plataforma.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long>{
	Usuario findByUserName(String username);
}
