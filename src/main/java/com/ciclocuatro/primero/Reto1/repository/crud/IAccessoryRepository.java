package com.ciclocuatro.primero.Reto1.repository.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ciclocuatro.primero.Reto1.model.Accessory;

public interface IAccessoryRepository extends MongoRepository<Accessory, String>{
    public List<Accessory> findByPriceLessThanEqual(double precio);
    
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Accessory> findByDescriptionLike(String description);

}
