package com.recepie.recepie.controllers;

import com.recepie.recepie.domain.Category;
import com.recepie.recepie.domain.UnitOfMeasure;
import com.recepie.recepie.repositories.CategoryRepository;
import com.recepie.recepie.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.System;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;


    /**
     * Returns the index Thymeleaf template
     * takes three paths empty string, '/', '/index'
     * @return
     */
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> category = categoryRepository.findByDescription("Indian");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Id of category: "+ category.get().getId());
        System.out.println("Id of UnitOfMeasure: "+ unitOfMeasure.get().getId());
        return "index";

    }

}
