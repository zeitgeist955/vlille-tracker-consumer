package com.vlilletracker.consumer.model;

import lombok.Data;

@Data
public class Station {

    // technical id ?
    private int libelle;

    private String nom;

    private String adresse;

    //TODO : enum
    private String commune;

    private String etat;

    // Avec ou Sans TPE
    private String type;

    private Location geo;

    private int nbplacesdispo;

    private int nbvelosdispo;

    private String etatconnexion;

    private Location localisation;

    //TODO date ?
    private String datemiseajour;
}
