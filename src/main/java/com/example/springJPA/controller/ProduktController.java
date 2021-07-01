package com.example.springJPA.controller;


import com.example.springJPA.entity.Produkt;
import com.example.springJPA.service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProduktController {

    @Autowired
    private ProduktService produktService;

    //Post-------------------------------------------------------------
    @PostMapping ("/pridajProdukt")
    public Produkt addProdukt (@RequestBody Produkt produkt){
        return produktService.pridajProdukt(produkt);
    }

    @PostMapping ("/pridajProdukty")
    public List <Produkt> addProdukty (@RequestBody List <Produkt> produkty){
        return produktService.pridajListProduktov(produkty);
    }

    //Get------------------------------------------------------------------
    @GetMapping ("/produkty")
    public List <Produkt> vratListProduktov (){
        return produktService.vyhladajProdukty();
    }

    @GetMapping ("/produktById/{id}")
    public Produkt vratProduktById (@PathVariable int id ){
        return produktService.vyhladajProduktById(id);
    }

    @GetMapping ("/produktByMeno/{meno}")
    public Produkt vratProduktByName (@PathVariable String meno){
        return produktService.vyhladajProduktByName(meno);
    }

    @GetMapping ("produktyByZnacka/{znacka}")
    public List <Produkt> vratProduktyByZnacka (@PathVariable String znacka){
        return produktService.vyhladajProduktyByZnacka(znacka);
    }

    //Put------------------------------------------------------------------

    @PutMapping ("/updateProdukt")
    public Produkt updateProdukt (@RequestBody Produkt produkt){
        return produktService.auktualizujProdukt(produkt);

    }

    //Delete----------------------------------------------------------------

    @DeleteMapping ("/delete/{id}")
    public String deleteProdukt (@PathVariable int id){
        return produktService.vymazProdukt(id);
    }


}
