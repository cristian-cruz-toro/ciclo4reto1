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
import com.ciclocuatro.primero.Reto1.model.User;
import com.ciclocuatro.primero.Reto1.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService servicioUsuario;
	
    @GetMapping("/all")
    public List<User> getAll() {
        return servicioUsuario.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<User>  getUser(@PathVariable("reference") Integer id) {
        return servicioUsuario.getUser(id);
    }
    
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User agregar(@RequestBody User user) {
        return servicioUsuario.agregar(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicioUsuario.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicioUsuario.delete(id);
    }
    
    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
    	User usuario1=servicioUsuario.autenticarUsuario(email, password);
    	return usuario1;
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return servicioUsuario.existeEmail(email);
    }   

}
