
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
@Table(name = "patients")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Patient_id ;
	
	

    @Column(name="Patient_nom")
    private String Patient_nom;
    
    

    @Column(name="Patient_prenom")
    private String Patient_prenom;
    
    @Column(name="Patient_numero")
    private String Patient_numero;
    
    @Column(name="Patient_blessure")
    private String Patient_blessure;

    @Column(name="Patient_specialisation")
    private String Patient_specialisation;
    
    @Column(name="Patient_localisation")
    private String Patient_localisation;

    

	public Long getPatient_id() {
		return Patient_id;
	}

	public void setPatient_id(Long Patient_id) {
		this.Patient_id = Patient_id;
	}
	
	

	public String getPatient_nom() {
		return Patient_nom;
	}

	public void setPatient_nom(String Patient_nom) {
		this.Patient_nom = Patient_nom;
	}
	
	public String getPatient_prenom() {
		return Patient_prenom;
	}

	public void setPatient_prenom(String Patient_prenom) {
		this.Patient_prenom = Patient_prenom;
	}

	public String getPatient_numero() {
		return Patient_numero;
	}

	public void setPatient_numero(String Patient_numero) {
		this.Patient_numero = Patient_numero;
	}

	public String getPatient_blessure() {
		return Patient_blessure;
	}

	public void setPatient_blessure(String Patient_blessure) {
		this.Patient_blessure = Patient_blessure;
	}
	
	public String getPatient_specialisation() {
		return Patient_specialisation;
	}

	public void setPatient_specialisation(String Patient_specialisation) {
		this.Patient_specialisation = Patient_specialisation;
	}
	
	public String getPatient_localisation() {
		return Patient_localisation;
	}

	public void setPatient_localisation(String Patient_localisation) {
		this.Patient_localisation = Patient_localisation;
	}

	


}
