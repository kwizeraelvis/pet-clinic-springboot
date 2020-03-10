package com.elvis.springapp.petclinic.bootstrap;

import com.elvis.springapp.petclinic.model.Owner;
import com.elvis.springapp.petclinic.model.Pet;
import com.elvis.springapp.petclinic.model.PetType;
import com.elvis.springapp.petclinic.model.Vet;
import com.elvis.springapp.petclinic.services.OwnerService;
import com.elvis.springapp.petclinic.services.PetTypeService;
import com.elvis.springapp.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("PetTypes loaded");

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
        vet1.setFirstName("Byiringiro");
        vet1.setLastName("Phocas");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Byiringiro");
        vet2.setLastName("Asante");
        vetService.save(vet2);

        System.out.println("Vets Loaded");


    }
}
