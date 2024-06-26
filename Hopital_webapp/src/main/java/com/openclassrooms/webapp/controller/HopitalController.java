
package com.openclassrooms.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.webapp.model.Hopital;
import com.openclassrooms.webapp.service.HopitalService;

import lombok.Data;

@Data
@Controller
public class HopitalController {

	@Autowired
	private HopitalService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		Iterable<Hopital> listHopital = service.getHopitaux();
		model.addAttribute("hopitaux", listHopital);
		return "home";
	}
	
	@GetMapping("/createHopital")
	public String createHopital(Model model) {
		Hopital e = new Hopital();
		model.addAttribute("hopital", e);
		return "formNewHopital";
	}
	
	
	@GetMapping("/updatebedhopital/{id}")
	public String updatebedhopital(@PathVariable("id") final int id, Model model) {
	    Hopital e = service.getHopital(id);  // Récupérer l'hôpital par ID
	    if (e != null) {
	        Integer litsDisponibles = e.getlits_disponibles();
	        if (litsDisponibles != null && litsDisponibles > 0) {
	            service.updatebedhopital(id);  // Mettre à jour les lits disponibles
	            model.addAttribute("hopital", e);
	            model.addAttribute("status", "success");
	        } else {
	            model.addAttribute("hopital", e);  // Ajouter l'hôpital même si aucun lit n'est disponible
	            model.addAttribute("status", "noBedsAvailable");
	        }
	    } else {
	        // Créer un objet Hopital vide pour éviter l'erreur dans le template
	        model.addAttribute("hopital", new Hopital());
	        model.addAttribute("status", "notFound");
	    }

	    return "formReserverLit"; 
	}

	@GetMapping("/updatebedhopitalPatient/{id}")
	public String updatebedhopitalPatient(@PathVariable("id") final int id, Model model) {
	    Hopital e = service.getHopital(id);  // Récupérer l'hôpital par ID
	    if (e != null) {
	        Integer litsDisponibles = e.getlits_disponibles();
	        if (litsDisponibles != null && litsDisponibles > 0) {
	            service.updatebedhopital(id);  // Mettre à jour les lits disponibles
	            model.addAttribute("hopital", e);
	            model.addAttribute("status", "success");
	        } else {
	            model.addAttribute("hopital", e);  // Ajouter l'hôpital même si aucun lit n'est disponible
	            model.addAttribute("status", "noBedsAvailable");
	        }
	    } else {
	        // Créer un objet Hopital vide pour éviter l'erreur dans le template
	        model.addAttribute("hopital", new Hopital());
	        model.addAttribute("status", "notFound");
	    }

	    return "formReserverLitPatient"; 
	}


	
	@GetMapping("/updateHopital/{id}")
	public String updateHopital(@PathVariable("id") final int id, Model model) {
		Hopital e = service.getHopital(id);		
		model.addAttribute("hopital", e);	
		return "formUpdateHopital";		
	}
	
	@GetMapping("/deleteHopital/{id}")
	public ModelAndView deleteHopital(@PathVariable("id") final int id) {
		service.deleteHopital(id);
		return new ModelAndView("redirect:/home");		
	}
	
	@PostMapping("/saveHopital")
	public ModelAndView saveHopital(@ModelAttribute Hopital hopital) {
		if(hopital.getId() != null) {
			
			Hopital current = service.getHopital(hopital.getId());
			hopital.setlits_disponibles(current.getlits_disponibles());
		}
		service.saveHopital(hopital);
		return new ModelAndView("redirect:/home");	
	}
	
	@PostMapping("/saveHopitalPatient")
	public ModelAndView saveHopitalPatient(@ModelAttribute Hopital hopital) {
		if(hopital.getId() != null) {
			
			Hopital current = service.getHopital(hopital.getId());
			hopital.setlits_disponibles(current.getlits_disponibles());
		}
		service.saveHopital(hopital);
		return new ModelAndView("redirect:/Patient");	
	}
}
