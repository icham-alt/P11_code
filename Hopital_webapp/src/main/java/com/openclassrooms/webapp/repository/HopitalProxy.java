
package com.openclassrooms.webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.openclassrooms.webapp.CustomProperties;
import com.openclassrooms.webapp.model.Hopital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HopitalProxy {

	@Autowired
	private CustomProperties props;
	
	private static final Logger log = LoggerFactory.getLogger(HopitalProxy.class);


	/**
	 * Get all hopitaux
	 * @return An iterable of all hopitaux
	 */
	public Iterable<Hopital> getHopitaux() {

		String baseApiUrl = props.getApiUrl();
		String getHopitauxUrl = baseApiUrl + "/hopitaux";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Hopital>> response = restTemplate.exchange(
				getHopitauxUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Hopital>>() {}
			);
		
		log.debug("Get Hopitaux call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Get an hopital by the id
	 * @param id The id of the Hopital
	 * @return The Hopital which matches the id
	 */
	public Hopital getHopital(int id) {
		
		String baseApiUrl = props.getApiUrl();
		String getHopitalUrl = baseApiUrl + "/hopital/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Hopital> response = restTemplate.exchange(
				getHopitalUrl, 
				HttpMethod.GET, 
				null,
				Hopital.class
			);
		
		log.debug("Get Hopital call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Get an hopital by the adresse
	 * @param id The id of the Hopital
	 * @return The Hopital which matches the id
	 */
	public Hopital getHopitalbyadresse(String adresse) {
		
		String baseApiUrl = props.getApiUrl();
		String getHopitalUrl = baseApiUrl + "/hopital/adresse/" + adresse;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Hopital> response = restTemplate.exchange(
				getHopitalUrl, 
				HttpMethod.GET, 
				null,
				Hopital.class
			);
		
		log.debug("Get Hopital call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Add a new Hopital 
	 * @param e A new Hopital (without an id)
	 * @return The Hopital full filled (with an id)
	 */
	public Hopital createHopital(Hopital e) {
		String baseApiUrl = props.getApiUrl();
		String createHopitalUrl = baseApiUrl + "/hopital";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Hopital> request = new HttpEntity<Hopital>(e);
		ResponseEntity<Hopital> response = restTemplate.exchange(
				createHopitalUrl, 
				HttpMethod.POST, 
				request, 
				Hopital.class);
		
		log.debug("Create Hopital call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Update an Hopital - using the PUT HTTP Method.
	 * @param e Existing Hopital to update
	 */
	public Hopital updateHopital(Hopital e) {
		String baseApiUrl = props.getApiUrl();
		String updateHopitalUrl = baseApiUrl + "/hopital/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Hopital> request = new HttpEntity<Hopital>(e);
		ResponseEntity<Hopital> response = restTemplate.exchange(
				updateHopitalUrl, 
				HttpMethod.PUT, 
				request, 
				Hopital.class);
		
		log.debug("Update Hopital call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Update an bed Hopital - using the PUT HTTP Method.
	 * @param e Existing Hopital to update
	 */
	public Hopital updatebedhopital(int id) {
		String baseApiUrl = props.getApiUrl();
		String updatebedhopitalUrl = baseApiUrl + "/updatebedhopital/" + id;

		RestTemplate restTemplate = new RestTemplate();
		//HttpEntity<Hopital> request = new HttpEntity<Hopital>(e);
		ResponseEntity<Hopital> response = restTemplate.exchange(
				updatebedhopitalUrl, 
				HttpMethod.PUT, 
				null, 
				Hopital.class);
		
		log.debug("Update beds Hopital call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	 * Delete an Hopital using exchange method of RestTemplate
	 * instead of delete method in order to log the response status code.
	 * @param e The Hopital to delete
	 */
	public void deleteHopital(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteHopitalUrl = baseApiUrl + "/hopital/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteHopitalUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete Hopital call " + response.getStatusCode().toString());
	}

}