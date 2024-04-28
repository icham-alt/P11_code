package com.openclassrooms.webapp.service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculationService {

    private final String apiKey = "AIzaSyABsGuhKcyKI06NxaH7K7j_8fuevA3ydPY"; 
    
    public String[][] calculateDistances(String[] origins, String[] destinations) {
        try {
            System.out.println("Calcul des distances en cours...");
            GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();
            System.out.println("Contexte GeoApi créé avec succès.");
            DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context)
                    .origins(origins)
                    .destinations(destinations)
                    .await();
            System.out.println("Distances calculées avec succès.");

            // Créer un tableau pour stocker les destinations et les distances
            String[][] destinationsAndDistances = new String[destinations.length][2];

            // Construire le tableau des destinations et des distances
            for (int i = 0; i < origins.length; i++) {
                for (int j = 0; j < destinations.length; j++) {
                    String destination = destinations[j];
                    DistanceMatrixElement element = distanceMatrix.rows[i].elements[j];
                    String distance = element.distance.humanReadable;

                 // Extraire uniquement la valeur numérique de la distance
                    double numericDistance = Double.parseDouble(distance.split(" ")[0]);
                    
                    // Stocker les destinations et les distances dans le tableau
                    destinationsAndDistances[j][0] = destination;
                    destinationsAndDistances[j][1] = String.valueOf(numericDistance);
                }
            }

            return destinationsAndDistances;
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors du calcul des distances : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }






    
}
