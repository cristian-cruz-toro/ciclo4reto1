package com.ciclocuatro.primero.Reto1.repository.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ciclocuatro.primero.Reto1.model.User;

public interface IUserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByEmailAndPassword(String email,String password);
}
