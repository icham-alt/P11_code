
package com.openclassrooms.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.webapp.model.Patient;
import com.openclassrooms.webapp.repository.PatientProxy;

import lombok.Data;

@Data
@Service
public class PatientService {

    @Autowired
    private PatientProxy PatientProxy;

    public Patient getPatient(final int Patient_id) {
        return PatientProxy.getPatient(Patient_id);
    }

    public Iterable<Patient> getPatients() {
        return PatientProxy.getPatients();
    }

    public void deletePatient(final int Patient_id) {
        PatientProxy.deletePatient(Patient_id);
    }
    
    

     public Patient savePatient(Patient Patient) {
    	 Patient savedPatient;

        
        Patient.setPatient_nom(Patient.getPatient_nom());

        if(Patient.getPatient_id() == null) {
            // Si l'id est nul, alors c'est un nouveau Patient.
            savedPatient = PatientProxy.createPatient(Patient);
        } else {
            savedPatient = PatientProxy.updatePatient(Patient);
        }
    
        return savedPatient;
    }

}