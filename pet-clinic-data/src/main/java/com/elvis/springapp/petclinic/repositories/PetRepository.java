package com.elvis.springapp.petclinic.repositories;

import com.elvis.springapp.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
