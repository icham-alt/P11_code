
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
@Table(name = "hopitaux")
public class Hopital {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Hopital_nom")
    private String Hopital_nom;

    @Column(name="hopitaladresse")
    private String hopitaladresse;

    @Column(name="Specialisation")
    private String Specialisation;

    @Column(name="lits_disponibles")
    private Integer lits_disponibles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHopital_nom() {
		return Hopital_nom;
	}

	public void setHopital_nom(String Hopital_nom) {
		this.Hopital_nom = Hopital_nom;
	}

	public String gethopitaladresse() {
		return hopitaladresse;
	}

	public void sethopitaladresse(String hopitaladresse) {
		this.hopitaladresse = hopitaladresse;
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
