package com.elvis.springapp.petclinic.controllers;

import com.elvis.springapp.petclinic.model.Owner;
import com.elvis.springapp.petclinic.services.OwnerService;
import com.elvis.springapp.petclinic.services.jpaServices.OwnerJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setup(){
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).firstname("Rukundo").build());
        owners.add(Owner.builder().id(2L).firstname("Higiro").build());
        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void listOfOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().is(200))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwner() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));
        verifyNoInteractions(ownerService);
    }
}