package com.ciclocuatro.primero.Reto1.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ciclocuatro.primero.Reto1.model.Accessory;

public interface IAccessoryRepository extends MongoRepository<Accessory, String>{

}
