package com.ciclocuatro.primero.Reto1.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ciclocuatro.primero.Reto1.model.Orden;

public interface IOrderCrudRepository extends MongoRepository<Orden, Integer> {
	
	@Query("{'salesMan.zone': ?0}")
	List<Orden> porZona(final String zona);
	
	@Query("{status: ?0}")
	List<Orden> porEstado(final String stado);
 
	Optional<Orden> findTopByOrderByIdDesc();
}
