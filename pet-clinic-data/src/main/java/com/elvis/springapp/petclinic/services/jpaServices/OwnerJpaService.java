package com.elvis.springapp.petclinic.services.jpaServices;

import com.elvis.springapp.petclinic.model.Owner;
import com.elvis.springapp.petclinic.repositories.OwnerRepository;
import com.elvis.springapp.petclinic.repositories.PetRepository;
import com.elvis.springapp.petclinic.repositories.PetTypeRepository;
import com.elvis.springapp.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService{

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository,
                           PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
            ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
             ownerRepository.deleteById(id);
    }
}
