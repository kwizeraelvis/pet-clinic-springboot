package com.elvis.springapp.petclinic.repositories;

import com.elvis.springapp.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
