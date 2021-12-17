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

import com.ciclocuatro.primero.Reto1.model.Orden;
import com.ciclocuatro.primero.Reto1.service.OrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrdenController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/all")
	public List<Orden> getAll() {
		return orderService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Orden> getOrder(@PathVariable("id") int id) {
		return orderService.getOrder(id);
	}

	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden create(@RequestBody Orden gadget) {
		return orderService.create(gadget);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden update(@RequestBody Orden gadget) {
		return orderService.update(gadget);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int id) {
		return orderService.delete(id);
	}

	@GetMapping("/zona/{zona}")
	public List<Orden> findByZone(@PathVariable("zona") String zona) {
		return orderService.findByZone(zona);
	}

	@GetMapping("/salesman/{id}")
	public List<Orden> ordersSalesManByID(@PathVariable("id") Integer id) {
		return orderService.ordersSalesManByID(id);
	}

	@GetMapping("/state/{state}/{id}")
	public List<Orden> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id) {
		return orderService.ordersSalesManByState(state, id);
	}

	@GetMapping("/date/{date}/{id}")
	public List<Orden> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
		return orderService.ordersSalesManByDate(dateStr, id);
	}

}
