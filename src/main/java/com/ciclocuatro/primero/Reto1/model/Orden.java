package com.ciclocuatro.primero.Reto1.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {
	public static String PENDING="pendiente";
	public static String APROVED="Aprobada";
	public static String REJECTED= "Rechazada";
	
	@Id
	private Integer id;
	private Date registerDay;
	private String status;
	private User salesMan;
	
	private Map<String, Accessory> products;
	private Map<String , Integer> quantities;
	

}
