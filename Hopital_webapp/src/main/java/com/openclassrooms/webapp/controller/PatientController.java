
package com.openclassrooms.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.webapp.model.Patient;
import com.openclassrooms.webapp.service.PatientService;

import lombok.Data;

@Data
@Controller
public class PatientController {

	@Autowired
	private PatientService service;
	
	@GetMapping("/")
	public String Accueil(Model model) {
		
		return "Accueil";
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
	
	
	
	
	@GetMapping("/updatePatient/{id}")
	public String updatePatient(@PathVariable("id") final int Patient_id, Model model) {
		Patient e = service.getPatient(Patient_id);		
		model.addAttribute("Patient", e);	
		return "formUpdatePatient";		
	}
	
	@GetMapping("/deletePatient/{id}")
	public ModelAndView deletePatient(@PathVariable("id") final int Patient_id) {
		service.deletePatient(Patient_id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/savePatient")
	public ModelAndView savePatient(@ModelAttribute Patient Patient) {
		if(Patient.getPatient_id() != null) {
			// Patient from update form has the password field not filled,
			// so we fill it with the current password.
			Patient current = service.getPatient(Patient.getPatient_id());
			
		}
		service.savePatient(Patient);
		return new ModelAndView("redirect:/");	
	}
	
}