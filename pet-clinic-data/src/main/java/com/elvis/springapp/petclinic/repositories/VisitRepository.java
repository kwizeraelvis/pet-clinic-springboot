package com.elvis.springapp.petclinic.repositories;

import com.elvis.springapp.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
