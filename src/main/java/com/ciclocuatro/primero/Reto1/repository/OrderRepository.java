package com.ciclocuatro.primero.Reto1.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ciclocuatro.primero.Reto1.model.Orden;
import com.ciclocuatro.primero.Reto1.repository.crud.IOrderCrudRepository;

@Repository
public class OrderRepository {
	
	@Autowired
	private IOrderCrudRepository ordenRepositorio;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
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

    public List<Orden> ordersSalesManByID(Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Orden> orders = mongoTemplate.find(query, Orden.class);

        return orders;
    }
    
    public List<Orden> ordersSalesManByState(String state, Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(dateCriteria);
        List<Orden> orders = mongoTemplate.find(query, Orden.class);

        return orders;
    }
    
   
    public List<Orden> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Orden> orders = mongoTemplate.find(query, Orden.class);

        return orders;
    }
}
