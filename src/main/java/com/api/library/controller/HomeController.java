package com.api.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@RestController
public class HomeController {

    @GetMapping
    private String homeView(){
      return "Library API works";
    }
}
