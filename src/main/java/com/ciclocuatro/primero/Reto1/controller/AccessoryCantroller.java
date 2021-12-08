package com.ciclocuatro.primero.Reto1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ciclocuatro.primero.Reto1.model.Accessory;
import com.ciclocuatro.primero.Reto1.service.AccessoryService;

@RestController
@RequestMapping("/api/accessory")
@CrossOrigin("*")
public class AccessoryCantroller {
	
	@Autowired
	private AccessoryService serviceAccesory;
	
    @GetMapping("/all")
    public List<Accessory> listAll() {
    	return serviceAccesory.listAll();
    }

    @GetMapping("/{reference}")
    public Optional<Accessory> getAccesory(@PathVariable("reference") String reference) {
        return serviceAccesory.getAccesory(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory create(@RequestBody Accessory accessory) {
        return serviceAccesory.create(accessory);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory update(@RequestBody Accessory accessory) {
        return serviceAccesory.update(accessory);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return serviceAccesory.delete(reference);
    }

}
