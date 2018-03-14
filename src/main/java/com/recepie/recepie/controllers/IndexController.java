package com.recepie.recepie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * Returns the index Thymeleaf template
     * takes three paths empty string, '/', '/index'
     * @return
     */
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        return "index";

    }

}
