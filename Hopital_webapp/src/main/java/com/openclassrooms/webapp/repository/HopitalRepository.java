package com.openclassrooms.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.openclassrooms.webapp.model.Hopital;
import com.openclassrooms.webapp.model.User;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.*;


public interface HopitalRepository extends JpaRepository<Hopital, Integer> {
    Hopital findByhopitaladresse( String hopitaladresse);
    
}

