package com.openclassrooms.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.openclassrooms.webapp.model.User;
import com.openclassrooms.webapp.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;




import lombok.Data;

@Data
@Controller
public class AuthController {
	

	    @Autowired
	    private UserRepository userRepository;

	    @GetMapping("/login")
	    public String loginPage() {
	        return "login"; // Créez une page HTML appelée login.html dans src/main/resources/templates
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpServletRequest request) {
	        // Code pour effacer ou invalider les informations de session ou de connexion
	        //HttpSession session = request.getSession();
	        //session.invalidate();
	        // Redirection vers la page de connexion
	        return "redirect:/login";
	    }

	    @PostMapping("/login")
	    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	        User user = userRepository.findByEmail(email);
	        String erreur = "Email";
	        if (user != null && user.getpassword().equals(password)) {
	        	model.addAttribute("profile", user.getProfile());
	        	System.out.println("Profile: " + user.getProfile());
	            return "Accueil"; // Rediriger vers la page de tableau de bord si l'authentification réussit
	        } else {
	        	
	            return "redirect:/login?error=true"; // Rediriger vers la page de connexion avec une erreur si l'authentification échoue
	        }
	    }

	    @GetMapping("/register")
	    public String registerPage() {
	        return "register"; // Créez une page HTML appelée register.html dans src/main/resources/templates
	    }

	    @PostMapping("/register")
	    public String register(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("profile") String profile) {
	        User existingUser = userRepository.findByEmail(email);
	        if (existingUser != null) {
	            return "redirect:/register?error=true"; // Rediriger vers la page d'inscription avec une erreur si l'utilisateur existe déjà
	        }
	        User user = new User();
	        user.setemail(email);
	        user.setpassword(password);
	        user.setProfile(profile);
	        userRepository.save(user);
	        return "redirect:/login"; // Rediriger vers la page de connexion après l'inscription réussie
	    }
	}


