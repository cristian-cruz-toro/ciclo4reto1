package com.ciclocuatro.primero.Reto1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclocuatro.primero.Reto1.model.User;
import com.ciclocuatro.primero.Reto1.repository.crud.IUserRepository;

@Repository
public class UserRepository {
	
	@Autowired
	IUserRepository repositoryI;
	
	 public List<User> getAll() {
	        return (List<User>) repositoryI.findAll();
	    }

	    public Optional<User> getUser(int id) {
	        return repositoryI.findById(id);
	    }

	    public User save(User user) {
	        return repositoryI.save(user);
	    }

	    public boolean existeEmail(String email) {
	        Optional<User> usuario = repositoryI.findByEmail(email);

	        return !usuario.isEmpty();
	    }

	    public Optional<User> autenticarUsuario(String email, String password) {
	        return repositoryI.findByEmailAndPassword(email, password);
	    }
	    
	    public void update(User user) {
	    	repositoryI.save(user);
	    }
	    
	    public void delete(User user) {
	    	repositoryI.delete(user);
	    }
	    
	    public boolean emailExist(String email) {
	        Optional<User> usuario = repositoryI.findByEmail(email);
	        return !usuario.isEmpty();
	    }

	    public Optional<User> autenticateUser(String email, String password) {
	        return repositoryI.findByEmailAndPassword(email, password);
	    }
	    
	     public Optional<User> lastUserId(){
	        return repositoryI.findTopByOrderByIdDesc();
	    }
	     
	    public List<User> listBirthtDayMonth(String month){
	        return repositoryI.findByMonthBirthtDay(month);
	    }

}
