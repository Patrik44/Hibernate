package com.example.springJPA.repository;

import com.example.springJPA.entity.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProduktRepository extends JpaRepository <Produkt, Integer> {


    Optional <Produkt> findByMeno(String meno);

    Optional<List<Produkt>> findAllByZnacka(String znacka);

}
