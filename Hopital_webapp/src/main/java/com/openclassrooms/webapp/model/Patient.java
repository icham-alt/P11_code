
package com.openclassrooms.webapp.model;

import lombok.Data;

@Data
public class Patient {
	
    private Integer Patient_id;

    private String Patient_nom;

    private String Patient_prenom;

    private String Patient_numero;
    
    private String Patient_blessure;
    
    private String Patient_specialisation;
    
    private String Patient_localisation;

    

	public Integer getPatient_id() {
		return Patient_id;
	}

	public void setPatient_id(Integer Patient_id) {
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
