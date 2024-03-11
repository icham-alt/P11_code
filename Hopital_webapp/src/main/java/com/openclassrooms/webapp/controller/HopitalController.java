
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
	    service.updatebedhopital(id);
	    Hopital e =  service.getHopital(id);		
		
	    if (model != null) {
	    	model.addAttribute("hopital", e);
	    }
	    return "formReserverLit"; 
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
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveHopital")
	public ModelAndView saveHopital(@ModelAttribute Hopital hopital) {
		if(hopital.getId() != null) {
			// Hopital from update form has the password field not filled,
			// so we fill it with the current password.
			Hopital current = service.getHopital(hopital.getId());
			hopital.setlits_disponibles(current.getlits_disponibles());
		}
		service.saveHopital(hopital);
		return new ModelAndView("redirect:/");	
	}
	
}