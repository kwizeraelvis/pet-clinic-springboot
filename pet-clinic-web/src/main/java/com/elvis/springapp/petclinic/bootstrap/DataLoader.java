package com.elvis.springapp.petclinic.bootstrap;

import com.elvis.springapp.petclinic.model.Owner;
import com.elvis.springapp.petclinic.model.Vet;
import com.elvis.springapp.petclinic.services.OwnerService;
import com.elvis.springapp.petclinic.services.VetService;
import com.elvis.springapp.petclinic.services.map.OwnerServiceMap;
import com.elvis.springapp.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;



    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Kwizera");
        owner1.setLastName("Elvis");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Higiro");
        owner2.setLastName("Emile");
        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Byiringiro");
        vet1.setLastName("Phocas");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Byiringiro");
        vet2.setLastName("Asante");
        vetService.save(vet2);

        System.out.println("Vets Loaded");


    }
}
