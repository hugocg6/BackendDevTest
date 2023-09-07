package com.example.similarproductsapirest.controller;

import com.example.similarproductsapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;
}
