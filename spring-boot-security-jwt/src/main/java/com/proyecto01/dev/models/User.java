package com.proyecto01.dev.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity// entidad JPA, mapeable a una tabla en una base de datos relacional
@Table(name = "auser") //nombre de la tabla en la base de datos
public class User {

	@Id//marca el campo 'id' como la clave primaria de la entidad
	@GeneratedValue(strategy = GenerationType.AUTO)
	//GeneratedValue Indica que el valor de la clave primaria será generado automáticamente
	//
	private Long id;
	@Column(unique = true)
	private String username;
	@Column(unique = true)
	private String email;
	private String password;

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

}
