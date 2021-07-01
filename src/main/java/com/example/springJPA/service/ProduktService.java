package com.example.springJPA.service;


import com.example.springJPA.entity.Produkt;
import com.example.springJPA.repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class ProduktService {

    @Autowired
    private ProduktRepository produktRepository;

    //Post----------------------------------------------
    public Produkt pridajProdukt (Produkt produkt){
       return produktRepository.save(produkt);
    }

    public List <Produkt> pridajListProduktov (List <Produkt> produkty) {
        return produktRepository.saveAll(produkty);
    }

    //Get-----------------------------------------------

    public List <Produkt> vyhladajProdukty (){
        return produktRepository.findAll();
    }

    public Produkt vyhladajProduktById (int id){
        return produktRepository.findById(id).orElse(null);
    }

    public Produkt vyhladajProduktByName (String meno) {
        return produktRepository.findByMeno(meno).orElse(null);
    }

   public List <Produkt> vyhladajProduktyByZnacka (String znacka){
        return produktRepository.findAllByZnacka(znacka).orElse(null);

    }

    //Delete---------------------------------------------------------

    public String vymazProdukt (int id) {
        produktRepository.deleteById(id);
        return "Produk id " + id + " bol vymazaný";
    }

    //Put-------------------------------------------------------------

    public Produkt auktualizujProdukt (Produkt produkt){
       Produkt updateProdukt =  produktRepository.findById(produkt.getId()).orElse(null);
        assert updateProdukt != null;
        updateProdukt.setMeno(produkt.getMeno());
       updateProdukt.setPocet(produkt.getPocet());
       updateProdukt.setCena(produkt.getCena());
       updateProdukt.setZnacka(produkt.getZnacka());
       return produktRepository.save(updateProdukt);


    }




}
