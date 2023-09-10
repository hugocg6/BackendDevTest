package com.example.similarproductsapirest.service;

import com.example.similarproductsapirest.dto.ProductDetailDTO;
import com.example.similarproductsapirest.dto.SimilarProductsDTO;

import java.util.Set;

public interface ProductService {

    ProductDetailDTO getProductProductId(String productId);
    SimilarProductsDTO getProductSimilarIds(String productId);
}
