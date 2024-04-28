package com.openclassrooms.api.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.Data;


@Data
@Entity
@Table(name = "Utilisateur")

public class Utilisateur {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Utilisateur_id ;
	
	
	@Column(name="Utilisateur_email")
    private String Utilisateur_email;
	
	@Column(name="Utilisateur_password")
    private String Utilisateur_password;
	
	public String getUtilisateur_email() {
		return Utilisateur_email;
	}

	public void setUtilisateur_email(String Utilisateur_email) {
		this.Utilisateur_email = Utilisateur_email;
	}
	
	public String getUtilisateur_password() {
		return Utilisateur_password;
	}

	public void setUtilisateur_password(String Utilisateur_password) {
		this.Utilisateur_password = Utilisateur_password;
	}

}
