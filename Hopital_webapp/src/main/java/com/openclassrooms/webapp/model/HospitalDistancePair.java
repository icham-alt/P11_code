package com.openclassrooms.webapp.model;

public class HospitalDistancePair implements Comparable<HospitalDistancePair> {
    private Hopital Hopital;
    private double distance;

    public HospitalDistancePair(Hopital Hopital, double distance) {
        this.Hopital = Hopital;
        this.distance = distance;
    }

    public Hopital getHopital() {
        return Hopital;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(HospitalDistancePair other) {
        return Double.compare(this.distance, other.distance);
    }
}

