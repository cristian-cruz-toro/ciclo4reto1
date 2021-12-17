package com.ciclocuatro.primero.Reto1.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ciclocuatro.primero.Reto1.model.User;

public interface IUserRepository extends MongoRepository<User, Integer>{
    
    public Optional <User> findByEmail(String email);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    

    Optional<User> findTopByOrderByIdDesc();
   
    List<User> findByMonthBirthtDay(String month);
}
