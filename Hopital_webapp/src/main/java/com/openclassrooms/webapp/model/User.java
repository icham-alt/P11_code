package com.openclassrooms.webapp.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String email;
private String password;
private String profile;


// Getters and setters
public Long getid() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getemail() {
	return email;
}

public void setemail(String email) {
	this.email = email;
}

public String getpassword() {
	return password;
}

public void setpassword(String password) {
	this.password = password;
		
}

public String getProfile() {
    return profile;
}

public void setProfile(String profile) {
    this.profile = profile;
}

}
