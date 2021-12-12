package com.ciclocuatro.primero.Reto1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
    @Id
    private Integer id;
    
    @NonNull
    @Column(name = "identification", nullable = false, length = 50)
    private String identification;
    
    @NonNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @NonNull
    @Column(name = "birthtDay")
    private Date birthtDay;
    
    @NonNull
    @Column(name = "monthBirthtDay", nullable = false, length = 100)
    private String monthBirthtDay;
    
    @NonNull
    @Column(name = "address", nullable = false, length = 50)
    private String address;
    
    @NonNull
    @Column(name = "cellPhone", nullable = false, length = 50)
    private String cellPhone;
    
    @NonNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    @NonNull
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    
    @NonNull
    @Column(name = "zone", nullable = false, length = 20)
    private String zone;
    
    @NonNull
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    
}
