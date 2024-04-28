
package com.openclassrooms.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassrooms.api.model.Hopital;
import com.openclassrooms.api.repository.HopitalRepository;

import lombok.Data;

@Data
@Service
public class HopitalService {
	
    @Autowired
    private HopitalRepository hopitalRepository;

    public Optional<Hopital> getHopital(final Long id) {
        return hopitalRepository.findById(id);
    }
    
    public  Hopital getHopitalbyAdresse(final String hopitaladresse) {
        return hopitalRepository.findByHopitaladresse(hopitaladresse);
    }


    public Iterable<Hopital> getHopitaux() {
        return hopitalRepository.findAll();
    }

    public void deleteHopital(final Long id) {
    	hopitalRepository.deleteById(id);
    }

    public Hopital saveHopital(Hopital hopital) {
    	Hopital savedHopital = hopitalRepository.save(hopital);
        return savedHopital;
    }

}
