package com.elvis.springapp.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String listvets(){
        return "vets/index";
    }
}
