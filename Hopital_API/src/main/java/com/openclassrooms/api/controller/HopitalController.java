package com.openclassrooms.api.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Hopital;
import com.openclassrooms.api.service.HopitalService;

@RestController
public class HopitalController {

    @Autowired
    private HopitalService hopitalService;
  
    
	/**
	 * Create - Add a new Hopital
	 * @param Hopital An object Hopital
	 * @return The Hopital object saved
	 */
	@PostMapping("/hopital")
	public Hopital createHopital(@RequestBody Hopital hopital) {
		return hopitalService.saveHopital(hopital);
	}
	
	
	/**
	 * Read - Get one hopital 
	 * @param id The id of the hopital
	 * @return An Hopital object full filled
	 */
	@GetMapping("/hopital/{id}")
	public Hopital getHopital(@PathVariable("id") final Long id) {
		Optional<Hopital> hopital = hopitalService.getHopital(id);
		if(hopital.isPresent()) {
			return hopital.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Read - Get one hopital by address
	 * @param hopitaladresse The address of the hopital
	 * @return An Hopital object if found, null otherwise
	 */
	 
	 @GetMapping("/hopital/adresse/{hopitaladresse}")
	    public Hopital getHopitalByAdresse(@PathVariable("hopitaladresse") String hopitaladresse) {
	        // Appeler le service pour récupérer l'hôpital par adresse
	        return hopitalService.getHopitalbyAdresse(hopitaladresse);
	    }
    /**
     * 
    * Read - Get all hopitaux
    * @return - An Iterable object of Hopitaux full filled
    */
    @GetMapping("/hopitaux")
    public Iterable<Hopital> getHopitaux() {
        return hopitalService.getHopitaux();
    }
    
    
    /**
	 * Update - Update an existing hopital
	 * @param id - The id of the hopital to update
	 * @param hopital - The hopital object updated
	 * @return
	 */
	@PutMapping("/hopital/{id}")
	public Hopital updateHopital(@PathVariable("id") final Long id, @RequestBody Hopital hopital) {
		Optional<Hopital> e = hopitalService.getHopital(id);
		if(e.isPresent()) {
			Hopital currentHopital = e.get();
			
			String Hopital_nom =  hopital.getHopital_nom();
			if(Hopital_nom != null) {
				currentHopital.setHopital_nom(Hopital_nom);
			}
			String hopitaladresse = hopital.gethopitaladresse();
			if(hopitaladresse != null) {
				currentHopital.sethopitaladresse(hopitaladresse);;
			}
			String Specialisation = hopital.getSpecialisation();
			if(Specialisation != null) {
				currentHopital.setSpecialisation(Specialisation);
			}
			Integer lits_disponibles = hopital.getlits_disponibles();
			if(lits_disponibles != null) {
				currentHopital.setlits_disponibles(lits_disponibles);;
			}
			hopitalService.saveHopital(currentHopital);
			return currentHopital;
		} else {
			return null;
		}
	}
	
	/**
	 * Update - Update number of bed
	 * @param id - The id of the hopital to update
	 * @param hopital - The hopital object updated
	 * @return
	 */
	@PutMapping("/updatebedhopital/{id}")
	public Hopital updatebedhopital(@PathVariable("id") final Long id) {
	    Optional<Hopital> e = hopitalService.getHopital(id);
	    if(e.isPresent()) {
	        Hopital currentHopital = e.get();
	        
	        Integer currentLitDispo = currentHopital.getlits_disponibles();
	        if(currentLitDispo != null && currentLitDispo > 0) {
	            currentHopital.setlits_disponibles(currentLitDispo - 1);
	            hopitalService.saveHopital(currentHopital);
	            return currentHopital;
	        } else {
	            // Peut-être gérer le cas où aucun lit n'est disponible
	            return null;
	        }
	    } else {
	        return null;
	    }
	}
	
	/**
	 * Update - Update number of bed
	 * @param id - The id of the hopital to update
	 * @param hopital - The hopital object updated
	 * @return
	 */
	@PutMapping("/updatebedhopitalPatient/{id}")
	public Hopital updatebedhopitalPatient(@PathVariable("id") final Long id) {
	    Optional<Hopital> e = hopitalService.getHopital(id);
	    if(e.isPresent()) {
	        Hopital currentHopital = e.get();
	        
	        Integer currentLitDispo = currentHopital.getlits_disponibles();
	        if(currentLitDispo != null && currentLitDispo > 0) {
	            currentHopital.setlits_disponibles(currentLitDispo - 1);
	            hopitalService.saveHopital(currentHopital);
	            return currentHopital;
	        } else {
	            // Peut-être gérer le cas où aucun lit n'est disponible
	            return null;
	        }
	    } else {
	        return null;
	    }
	}


	
	
	/**
	 * Delete - Delete an Hopital
	 * @param id - The id of the Hopital to delete
	 */
	@DeleteMapping("/hopital/{id}")
	public void deleteHopital(@PathVariable("id") final Long id) {
		hopitalService.deleteHopital(id);
	}
}
