package com.elvis.springapp.petclinic.services;

import com.elvis.springapp.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
   Owner findByLastName(String LastName);
}
