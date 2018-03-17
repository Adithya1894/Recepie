package com.recepie.recepie.bootstrap;

import com.recepie.recepie.domain.Category;
import com.recepie.recepie.domain.Recepie;
import com.recepie.recepie.domain.UnitOfMeasure;
import com.recepie.recepie.repositories.CategoryRepository;
import com.recepie.recepie.repositories.RecepieRepository;
import com.recepie.recepie.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecepieBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    //@Autowired
    private final CategoryRepository categoryRepository;
    private final RecepieRepository recepieRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecepieBootstrap(CategoryRepository categoryRepository, RecepieRepository recepieRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recepieRepository = recepieRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recepieRepository.saveAll(getRecipes());
    }


    private List<Recepie> getRecipes(){


        List<Recepie> recepies = new ArrayList<>(2);


        Optional<UnitOfMeasure> eachUom = unitOfMeasureRepository.findByDescription("Each");

        //UOM is Unit of Measure
        if(!eachUom.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");


        if(!teaspoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");


        if(!tablespoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");

        if(!tablespoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");

        if(!pinch.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> ounce = unitOfMeasureRepository.findByDescription("Ounce");


        if(!ounce.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        //getting the optianl values.
        //if a value is present in this optional, returns that value, otherwise throws noSuchElementException
        UnitOfMeasure eachUom1 = eachUom.get();

        UnitOfMeasure teaspoon1 = teaspoon.get();

        UnitOfMeasure tableSpoon1 = tablespoon.get();

        UnitOfMeasure cup1 = cup.get();

        UnitOfMeasure pinch1 = pinch.get();

        UnitOfMeasure ounce1 = ounce.get();

        //getting the categories of food from the database

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }




        return recepies;
    }
}
