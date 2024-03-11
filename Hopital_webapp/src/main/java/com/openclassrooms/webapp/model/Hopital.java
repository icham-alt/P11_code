
package com.openclassrooms.webapp.model;

import lombok.Data;

@Data
public class Hopital {
	
    private Integer id;

    private String Hopital_nom;

    private String Hopital_adresse;

    private String Specialisation;

    private Integer lits_disponibles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHopital_nom() {
		return Hopital_nom;
	}

	public void setHopital_nom(String Hopital_nom) {
		this.Hopital_nom = Hopital_nom;
	}

	public String getHopital_adresse() {
		return Hopital_adresse;
	}

	public void setHopital_adresse(String Hopital_adresse) {
		this.Hopital_adresse = Hopital_adresse;
	}

	public String getSpecialisation() {
		return Specialisation;
	}

	public void setSpecialisation(String Specialisation) {
		this.Specialisation = Specialisation;
	}

	public Integer getlits_disponibles() {
		return lits_disponibles;
	}

	public void setlits_disponibles(Integer lits_disponibles) {
		this.lits_disponibles = lits_disponibles;
	}

    
}
