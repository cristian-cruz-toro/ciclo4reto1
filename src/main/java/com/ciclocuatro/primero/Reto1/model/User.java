package com.ciclocuatro.primero.Reto1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "email", unique = true))
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @NonNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;  
}
