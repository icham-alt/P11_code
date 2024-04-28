
package com.openclassrooms.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.webapp.model.Hopital;
import com.openclassrooms.webapp.repository.HopitalProxy;
import com.openclassrooms.webapp.repository.HopitalRepository;

import lombok.Data;

@Data
@Service
public class HopitalService {

    @Autowired
    private HopitalProxy hopitalProxy;
    
    @Autowired
    private HopitalRepository HopitalRepository;

    public Hopital getHopital(final int id) {
        return hopitalProxy.getHopital(id);
    }

    public Iterable<Hopital> getHopitaux() {
        return hopitalProxy.getHopitaux();
    }

    public void deleteHopital(final int id) {
        hopitalProxy.deleteHopital(id);
    }
    
    public void updatebedhopital(final int id) {
        hopitalProxy.updatebedhopital(id);
    }

     public Hopital saveHopital(Hopital hopital) {
    	 Hopital savedHopital;

        
        hopital.setHopital_nom(hopital.getHopital_nom());

        if(hopital.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel hopital.
            savedHopital = hopitalProxy.createHopital(hopital);
        } else {
            savedHopital = hopitalProxy.updateHopital(hopital);
        }
    
        return savedHopital;
    }
     
     public String[] getAllHopitalAddresses() {
    	    Iterable<Hopital> hopitals = hopitalProxy.getHopitaux();
    	    List<String> addresses = new ArrayList<>();

    	    // Log pour vérifier si la récupération des hôpitaux est réussie
    	    System.out.println("Récupération des hôpitaux depuis hopitalProxy : " + hopitals);

    	    for (Hopital hopital : hopitals) {
    	        // Log pour vérifier chaque adresse d'hôpital
    	        System.out.println("Adresse de l'hôpital : " + hopital.getHopitaladresse());
    	        
    	        addresses.add(hopital.getHopitaladresse());
    	    }

    	    // Log pour vérifier les adresses récupérées
    	    System.out.println("Adresses des hôpitaux récupérées : " + addresses);

    	    return addresses.toArray(new String[0]);
    	}

     
     public List<Hopital> filterHopitalsByAddresses(List<Hopital> nearestHopitals) {
    	    List<Hopital> filteredHopitals = new ArrayList<>();
    	    for (Hopital nearestHopital : nearestHopitals) {
    	        String hopitalAdresse = nearestHopital.getHopitaladresse();
    	        // Ajoutez un log pour vérifier l'adresse de l'hôpital actuellement traitée
    	        System.out.println("Adresse de l'hôpital en cours de traitement : " + hopitalAdresse);
    	        
    	        // Utilisez la méthode findByhopitaladresse pour trouver l'hôpital dans la base de données
    	        Hopital filteredHopital = HopitalRepository.findByhopitaladresse(hopitalAdresse);
    	        System.out.println("Infos hopitals : " + filteredHopital);
    	        
    	        Hopital testHopital = hopitalProxy.getHopitalbyadresse(hopitalAdresse);
    	        System.out.println("Infos hopitals 2 : " + testHopital);
    	        
    	        
    	        // Ajoutez un log pour vérifier si l'hôpital a été trouvé dans la base de données
    	        if (testHopital != null) {
    	            System.out.println("Hôpital trouvé pour l'adresse : " + hopitalAdresse);
    	            filteredHopitals.add(testHopital);
    	        } else {
    	            System.out.println("Aucun hôpital trouvé pour l'adresse : " + hopitalAdresse);
    	        }
    	    }
    	    return filteredHopitals;
    	}



}