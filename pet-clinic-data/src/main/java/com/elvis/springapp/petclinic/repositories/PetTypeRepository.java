package com.elvis.springapp.petclinic.repositories;

import com.elvis.springapp.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
