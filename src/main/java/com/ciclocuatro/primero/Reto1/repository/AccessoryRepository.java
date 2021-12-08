package com.ciclocuatro.primero.Reto1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclocuatro.primero.Reto1.model.Accessory;
import com.ciclocuatro.primero.Reto1.repository.crud.IAccessoryRepository;



@Repository
public class AccessoryRepository {
	
	@Autowired
	private IAccessoryRepository interfaceRepository;
	
	public List<Accessory> listAll() {
        return interfaceRepository.findAll();
    }

    public Optional<Accessory> getAccesory(String reference) {
        return interfaceRepository.findById(reference);
    }

    public Accessory create(Accessory accesory) {
        return interfaceRepository.save(accesory);
    }

    public void update(Accessory accesory) {
    	interfaceRepository.save(accesory);
    }

    public void delete(Accessory accesory) {
    	interfaceRepository.delete(accesory);
    }

}
