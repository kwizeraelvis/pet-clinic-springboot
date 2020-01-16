package com.elvis.springapp.petclinic.services;

import com.elvis.springapp.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
