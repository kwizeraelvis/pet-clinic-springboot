package com.elvis.springapp.petclinic.repositories;

import com.elvis.springapp.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
