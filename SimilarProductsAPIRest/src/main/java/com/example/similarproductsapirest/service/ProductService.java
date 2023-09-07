package com.example.similarproductsapirest.service;

import com.example.similarproductsapirest.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findProductsById(String id);
}
