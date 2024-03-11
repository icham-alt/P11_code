
package com.openclassrooms.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.openclassrooms.webapp.CustomProperties;
import com.openclassrooms.webapp.model.Patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PatientProxy {

	@Autowired
	private CustomProperties props;
	
	private static final Logger log = LoggerFactory.getLogger(PatientProxy.class);


	/**
	 * Get all Patients
	 * @return An iterable of all Patients
	 */
	public Iterable<Patient> getPatients() {

		String baseApiUrl = props.getApiUrl();
		String getPatientsUrl = baseApiUrl + "/Patients";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Patient>> response = restTemplate.exchange(
				getPatientsUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Patient>>() {}
			);
		
		log.debug("Get Patients call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Get an Patient by the id
	 * @param id The id of the Patient
	 * @return The Patient which matches the id
	 */
	public Patient getPatient(int Patient_id) {
		
		String baseApiUrl = props.getApiUrl();
		String getPatientUrl = baseApiUrl + "/Patient/" + Patient_id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Patient> response = restTemplate.exchange(
				getPatientUrl, 
				HttpMethod.GET, 
				null,
				Patient.class
			);
		
		log.debug("Get Patient call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Add a new Patient 
	 * @param e A new Patient (without an id)
	 * @return The Patient full filled (with an id)
	 */
	public Patient createPatient(Patient e) {
		String baseApiUrl = props.getApiUrl();
		String createPatientUrl = baseApiUrl + "/Patient";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Patient> request = new HttpEntity<Patient>(e);
		ResponseEntity<Patient> response = restTemplate.exchange(
				createPatientUrl, 
				HttpMethod.POST, 
				request, 
				Patient.class);
		
		log.debug("Create Patient call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Update an Patient - using the PUT HTTP Method.
	 * @param e Existing Patient to update
	 */
	public Patient updatePatient(Patient e) {
		String baseApiUrl = props.getApiUrl();
		String updatePatientUrl = baseApiUrl + "/Patient/" + e.getPatient_id();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Patient> request = new HttpEntity<Patient>(e);
		ResponseEntity<Patient> response = restTemplate.exchange(
				updatePatientUrl, 
				HttpMethod.PUT, 
				request, 
				Patient.class);
		
		log.debug("Update Patient call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	
	
	/**
	 * Delete an Patient using exchange method of RestTemplate
	 * instead of delete method in order to log the response status code.
	 * @param e The Patient to delete
	 */
	public void deletePatient(int Patient_id) {
		String baseApiUrl = props.getApiUrl();
		String deletePatientUrl = baseApiUrl + "/Patient/" + Patient_id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deletePatientUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Patient call " + response.getStatusCode().toString());
	}

}