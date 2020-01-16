package com.elvis.springapp.petclinic.services;

import com.elvis.springapp.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
