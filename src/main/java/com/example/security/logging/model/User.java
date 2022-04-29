package com.example.security.logging.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	@Column(name = "nome_cognome")
	private String nomeCognome;
	
	
	
	
	public User() {
		super();
	}
	public User(String username, String password, String nomeCognome) {
		super();
		this.username = username;
		this.password = password;
		this.nomeCognome = nomeCognome;
	}
	public User(int id, String username, String password, String nomeCognome) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nomeCognome = nomeCognome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomeCognome() {
		return nomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nomeCognome=" + nomeCognome
				+ "]";
	}
	
	
}
