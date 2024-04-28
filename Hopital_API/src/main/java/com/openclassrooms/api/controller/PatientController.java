package com.openclassrooms.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Patient;
import com.openclassrooms.api.service.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService PatientService;
  
    
	/**
	 * Create - Add a new Patient
	 * @param Patient An object Patient
	 * @return The Patient object saved
	 */
	@PostMapping("/Patient")
	public Patient createPatient(@RequestBody Patient Patient) {
		return PatientService.savePatient(Patient);
	}
	
	
	/**
	 * Read - Get one Patient 
	 * @param id The id of the Patient
	 * @return An Patient object full filled
	 */
	@GetMapping("/Patient/{id}")
	public Patient getPatient(@PathVariable("id") final Long Patient_id) {
		Optional<Patient> Patient = PatientService.getPatient(Patient_id);
		if(Patient.isPresent()) {
			return Patient.get();
		} else {
			return null;
		}
	}
	
    /**
    * Read - Get all Patients
    * @return - An Iterable object of Patients full filled
    */
    @GetMapping("/Patients")
    public Iterable<Patient> getPatients() {
        return PatientService.getPatients();
    }
    
    
    /**
	 * Update - Update an existing Patient
	 * @param id - The id of the Patient to update
	 * @param Patient - The Patient object updated
	 * @return
	 */
	@PutMapping("/Patient/{id}")
	public Patient updatePatient(@PathVariable("id") final Long Patient_id, @RequestBody Patient Patient) {
		Optional<Patient> e = PatientService.getPatient(Patient_id);
		if(e.isPresent()) {
			Patient currentPatient = e.get();
			
			String Patient_nom =  Patient.getPatient_nom();
			if(Patient_nom != null) {
				currentPatient.setPatient_nom(Patient_nom);
			}
			String Patient_prenom = Patient.getPatient_prenom();
			if(Patient_prenom != null) {
				currentPatient.setPatient_prenom(Patient_prenom);;
			}
			String Patient_numero = Patient.getPatient_numero();
			if(Patient_numero != null) {
				currentPatient.setPatient_numero(Patient_numero);
			}
			String Patient_blessure = Patient.getPatient_blessure();
			if(Patient_blessure != null) {
				currentPatient.setPatient_blessure(Patient_blessure);;
			}
			String Patient_specialisation = Patient.getPatient_specialisation();
			if(Patient_specialisation != null) {
				currentPatient.setPatient_specialisation(Patient_specialisation);
			}
			
			String Patient_localisation = Patient.getPatient_localisation();
			if(Patient_localisation != null) {
				currentPatient.setPatient_localisation(Patient_localisation);
			}
			
			PatientService.savePatient(currentPatient);
			return currentPatient;
		} else {
			return null;
		}
	}
	
	
	

	
	
	/**
	 * Delete - Delete an Patient
	 * @param id - The id of the Patient to delete
	 */
	@DeleteMapping("/Patient/{id}")
	public void deletePatient(@PathVariable("id") final Long Patient_id) {
		PatientService.deletePatient(Patient_id);
	}
}
