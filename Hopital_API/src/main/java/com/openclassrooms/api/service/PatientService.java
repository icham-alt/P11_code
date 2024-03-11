
package com.openclassrooms.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openclassrooms.api.model.Patient;
import com.openclassrooms.api.repository.PatientRepository;

import lombok.Data;

@Data
@Service
public class PatientService {
	
    @Autowired
    private PatientRepository PatientRepository;

    public Optional<Patient> getPatient(final Long Patient_id) {
        return PatientRepository.findById(Patient_id);
    }

    public Iterable<Patient> getPatients() {
        return PatientRepository.findAll();
    }

    public void deletePatient(final Long Patient_id) {
    	PatientRepository.deleteById(Patient_id);
    }

    public Patient savePatient(Patient Patient) {
    	Patient savedPatient = PatientRepository.save(Patient);
        return savedPatient;
    }

}
