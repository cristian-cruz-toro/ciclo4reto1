package com.ciclocuatro.primero.Reto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclocuatro.primero.Reto1.model.Orden;
import com.ciclocuatro.primero.Reto1.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository ordenrepositorio;
	
    public List<Orden> getAll() {
        return ordenrepositorio.getAll();
    }

    public Optional<Orden> getOrder(int id) {
        return ordenrepositorio.getOrder(id);
    }

    public Orden create(Orden order) {

    
        Optional<Orden> orderIdMaxima = ordenrepositorio.lastUserId();

        if (order.getId() == null) {
             if (orderIdMaxima.isEmpty()) {
                order.setId(1);
            }else {
                order.setId(orderIdMaxima.get().getId() + 1);
            }
        }

        Optional<Orden> e = ordenrepositorio.getOrder(order.getId());
        if (e.isEmpty()) {
            return ordenrepositorio.create(order);
        } else {
            return order;
        }
    }

    public Orden update(Orden order) {

        if (order.getId() != null) {
            Optional<Orden> orderDb = ordenrepositorio.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                ordenrepositorio.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            ordenrepositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

   
    public List<Orden> findByZone(String zona) {
        return ordenrepositorio.findByZone(zona);
    }

    public List<Orden> ordersSalesManByID(Integer id) {
        return ordenrepositorio.ordersSalesManByID(id);
     }
    
    public List<Orden> ordersSalesManByState(String state, Integer id) {
        return ordenrepositorio.ordersSalesManByState(state,id);
    }
    
    public List<Orden> ordersSalesManByDate(String dateStr, Integer id){
        return ordenrepositorio.ordersSalesManByDate(dateStr, id);
    }
}
