
package com.openclassrooms.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.api.model.Hopital;


@Repository
public interface HopitalRepository extends CrudRepository<Hopital, Long> {
    Hopital findByHopitaladresse(String hopitaladresse);
}
