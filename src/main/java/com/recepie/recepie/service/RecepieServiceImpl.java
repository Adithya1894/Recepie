package com.recepie.recepie.service;

import com.recepie.recepie.domain.Recepie;
import com.recepie.recepie.repositories.RecepieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class RecepieServiceImpl implements RecepieService{

//    @Autowired
    private final RecepieRepository recepieRepository;


    public RecepieServiceImpl(RecepieRepository recepieRepository) {
        this.recepieRepository = recepieRepository;
    }

    @Override
    public Set<Recepie> getRecepies() {


        Set<Recepie> recepieSet = new HashSet<>();

        recepieRepository.findAll().iterator().forEachRemaining(recepieSet::add);

        return recepieSet;
    }
}
