
package com.openclassrooms.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.webapp.model.Hopital;
import com.openclassrooms.webapp.repository.HopitalProxy;

import lombok.Data;

@Data
@Service
public class HopitalService {

    @Autowired
    private HopitalProxy hopitalProxy;

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

}