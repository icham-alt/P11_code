
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
     
     public String getPatientAddress(int patientId) {
         // Récupérer le patient à partir de son ID
         Patient patient = PatientProxy.getPatient(patientId);

         // Vérifier si le patient existe
         if (patient != null) {
             // Retourner l'adresse du patient
             return patient.getPatient_localisation();
         } else {
             // Gérer le cas où le patient n'existe pas
             // Vous pouvez retourner null ou une chaîne vide selon vos besoins
             return null;
         }
     }

}