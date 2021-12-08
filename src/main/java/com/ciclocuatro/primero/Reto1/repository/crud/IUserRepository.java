package com.ciclocuatro.primero.Reto1.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.ciclocuatro.primero.Reto1.model.User;

public interface IUserRepository extends MongoRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	

    //@Query(value="select * from user where user.email = :email  and password = :password", nativeQuery = true)
	Optional<User> findByEmailAndPassword(String email, String password);
}
