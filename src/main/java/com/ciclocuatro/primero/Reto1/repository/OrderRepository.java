package com.ciclocuatro.primero.Reto1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclocuatro.primero.Reto1.model.Orden;
import com.ciclocuatro.primero.Reto1.repository.crud.IOrderCrudRepository;

@Repository
public class OrderRepository {
	
	@Autowired
	private IOrderCrudRepository ordenRepositorio;
	
    public List<Orden> getAll() {
        return (List<Orden>) ordenRepositorio.findAll();
    }
    
    public Optional<Orden> getOrder(int id) {
        return ordenRepositorio.findById(id);
    }

    public Orden create(Orden order) {
        return ordenRepositorio.save(order);
    }

    public void update(Orden order) {
    	ordenRepositorio.save(order);
    }

    public void delete(Orden order) {
    	ordenRepositorio.delete(order);
    }

    public Optional<Orden> lastUserId() {
        return ordenRepositorio.findTopByOrderByIdDesc();
    }

    public List<Orden> findByZone(String zona) {
        return ordenRepositorio.porZona(zona);
    }

}
