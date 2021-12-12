package com.ciclocuatro.primero.Reto1.model;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document(collection = "accessories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accessory {
	
	@NonNull
	@Id
    private String reference;
	
    @NonNull
    @Column(name = "brand")
    private String brand;
    
    @NonNull
    @Column(name = "category")
    private String category;
    
    @NonNull
    @Column(name = "material")
    private String material;
    
    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private boolean availability = true;

    @Column(name = "price")
    private double price;
    
   
    @Column(name = "quantity")
    private int quantity;
    
    @NonNull
    @Column(name = "photography")
    private String photography;

}
