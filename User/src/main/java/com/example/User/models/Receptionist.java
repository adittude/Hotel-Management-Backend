package com.example.User.models;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReceptionistInformation")
public class Receptionist {

	@Id
	private String id;
	private String email;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Receptionist(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Receptionist() {
		super();
	}

	@Override
	public String toString() {
		return "ReceptionistInformation [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}