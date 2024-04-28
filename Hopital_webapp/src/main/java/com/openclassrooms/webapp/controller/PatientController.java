
package com.openclassrooms.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.webapp.model.Hopital;
import com.openclassrooms.webapp.model.HospitalDistancePair;
import com.openclassrooms.webapp.model.Patient;
import com.openclassrooms.webapp.service.DistanceCalculationService;
import com.openclassrooms.webapp.service.HopitalService;
import com.openclassrooms.webapp.service.PatientService;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;

import lombok.Data;

@Data
@Controller
public class PatientController {

	@Autowired
	private PatientService service;
	
	
	
	@Autowired
	private HopitalService HopitalService;
	
	@Autowired
    private DistanceCalculationService distanceService;
	
	@GetMapping("/")
	public String Accueil(Model model) {
		
		return "login";
	}
	
	@GetMapping("/Patient")
	public String Patient(Model model) {
		Iterable<Patient> listPatient = service.getPatients();
		model.addAttribute("Patients", listPatient);
		return "Patient";
	}
	
	@GetMapping("/createPatient")
	public String createPatient(Model model) {
		Patient e = new Patient();
		model.addAttribute("Patient", e);
		return "formNewPatient";
	}
	
	
	
	
	@GetMapping("/updatePatient/{Patient_id}")
	public String updatePatient(@PathVariable("Patient_id") final int Patient_id, Model model) {
		Patient e = service.getPatient(Patient_id);		
		model.addAttribute("Patient", e);	
		return "formUpdatePatient";		
	}
	
	@GetMapping("/deletePatient/{Patient_id}")
	public ModelAndView deletePatient(@PathVariable("Patient_id") final int Patient_id) {
		service.deletePatient(Patient_id);
		return new ModelAndView("redirect:/Patient");		
	}
	
	@PostMapping("/savePatient")
	public ModelAndView savePatient(@ModelAttribute Patient Patient) {
		if(Patient.getPatient_id() != null) {
			// Patient from update form has the password field not filled,
			// so we fill it with the current password.
			Patient current = service.getPatient(Patient.getPatient_id());
			
		}
		service.savePatient(Patient);
		return new ModelAndView("redirect:/Patient");	
	}
	
	@GetMapping("/nearestHopitals/{Patient_id}")
	public String getNearestHopitals(@PathVariable("Patient_id") final int Patient_id, Model model) {
	    // Récupérer les adresses des hôpitaux depuis la base de données
	    String[] hopitalAddresses = HopitalService.getAllHopitalAddresses();
	    System.out.println("Adresses des hôpitaux : " + Arrays.toString(hopitalAddresses));

	    // Créer une nouvelle liste pour stocker les adresses des hôpitaux avec guillemets
	    List<String> quotedHopitalAddresses = new ArrayList<>();

	    // Entourer chaque adresse d'hôpital de guillemets
	    for (String address : hopitalAddresses) {
	        quotedHopitalAddresses.add("\"" + address + "\"");
	    }

	    // Convertir la liste en tableau
	    String[] quotedHopitalAddressesArray = quotedHopitalAddresses.toArray(new String[0]);

	    System.out.println("Adresses des hôpitaux : " + Arrays.toString(quotedHopitalAddressesArray));

	    // Récupérer l'adresse du patient
	    String patientAddress = service.getPatientAddress(Patient_id);
	    System.out.println("Adresse du patient : " + patientAddress);

	    // Calculer les distances entre l'adresse du patient et les hôpitaux
	    System.out.println("Calcul des distances pour l'adresse du patient : " + patientAddress);
	    String[][] destinationsAndDistances = distanceService.calculateDistances(new String[]{patientAddress}, hopitalAddresses);

	    // Afficher les détails de la matrice de distance
	    if (destinationsAndDistances != null) {
	        for (String[] entry : destinationsAndDistances) {
	            System.out.println("Destination: " + entry[0]);
	            System.out.println("Distance: " + entry[1]);
	            System.out.println("--------------------------");
	        }
	    } else {
	        System.out.println("La matrice de distance est null.");
	    }

	    // Extraire les hôpitaux les plus proches pour l'adresse du patient
	    List<Hopital> nearestHopitals = extractNearestHopitals(destinationsAndDistances);
	    System.out.println("Hôpitaux les plus proches pour l'adresse du patient : " + nearestHopitals);

	    
	    List<Hopital> fullnearestHopitals = HopitalService.filterHopitalsByAddresses(nearestHopitals);
	    
	    //System.out.println("Hôpitaux les plus proches pour l'adresse du patient : " + nearestHopitalAddresses);
	    System.out.println("Hôpitaux les plus proches pour l'adresse du patient : " + fullnearestHopitals);
	    
	    model.addAttribute("nearestHopitals", fullnearestHopitals);
	    return "nearestHopitals"; // Le nom de la nouvelle page HTML pour afficher les hôpitaux les plus proches
	}


	private List<Hopital> extractNearestHopitals(String[][] destinationsAndDistances) {
	    List<Hopital> nearestHopitals = new ArrayList<>();

	    // Vérifier si le tableau de destinations et de distances n'est pas null
	    if (destinationsAndDistances != null) {
	        // Convertir les distances en double pour pouvoir les trier
	        List<Double> distances = new ArrayList<>();
	        for (String[] entry : destinationsAndDistances) {
	            distances.add(Double.parseDouble(entry[1]));
	        }

	        // Trier les distances
	        Collections.sort(distances);

	        // Sélectionner les trois premières distances
	        for (int i = 0; i < Math.min(3, distances.size()); i++) {
	            // Trouver l'adresse correspondante à la distance
	            String nearestHopitalAddress = null;
	            for (String[] entry : destinationsAndDistances) {
	                if (Double.parseDouble(entry[1]) == distances.get(i)) {
	                    nearestHopitalAddress = entry[0];
	                    break;
	                }
	            }
	            // Créer un objet Hopital avec l'adresse trouvée
	            Hopital nearestHopital = new Hopital();
	            nearestHopital.setHopitaladresse(nearestHopitalAddress);
	            nearestHopitals.add(nearestHopital);
	        }
	    }

	    return nearestHopitals;
	}

}