package com.elvis.springapp.petclinic.bootstrap;

import com.elvis.springapp.petclinic.model.*;
import com.elvis.springapp.petclinic.services.OwnerService;
import com.elvis.springapp.petclinic.services.PetTypeService;
import com.elvis.springapp.petclinic.services.SpecialityService;
import com.elvis.springapp.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveddentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Kwizera");
        owner1.setLastName("Elvis");
        owner1.setAddress("KG344 Gasabo");
        owner1.setCity("Kigali");
        owner1.setTelephone("65555484");

        Pet elvisPet = new Pet();
        elvisPet.setPetType(savedDogPetType);
        elvisPet.setOwner(owner1);
        elvisPet.setBirthDate(LocalDate.now());
        elvisPet.setName("Cobra");
        owner1.getPets().add(elvisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Higiro");
        owner2.setLastName("Emile");
        owner2.setAddress("KG344 Gasabo");
        owner2.setCity("Kigali");
        owner2.setTelephone("65555484");

        Pet higirosCat = new Pet();
        higirosCat.setPetType(savedCatPetType);
        higirosCat.setOwner(owner2);
        higirosCat.setBirthDate(LocalDate.now());
        higirosCat.setName("Cobra");
        owner2.getPets().add(higirosCat);

        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Random");
        vet1.setLastName("Phocas");
//        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Random");
        vet2.setLastName("Asante");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);


        System.out.println("Vets Loaded");
    }
}
