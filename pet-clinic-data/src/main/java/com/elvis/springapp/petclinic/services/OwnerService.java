package com.elvis.springapp.petclinic.services;

import com.elvis.springapp.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
   Owner findByLastName();
   Owner findById(Long id);
   Owner save(Owner owner);
   Set<Owner> findAll();
}
