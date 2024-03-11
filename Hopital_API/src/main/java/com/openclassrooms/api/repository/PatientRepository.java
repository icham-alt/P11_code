
package com.openclassrooms.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.api.model.Patient;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
