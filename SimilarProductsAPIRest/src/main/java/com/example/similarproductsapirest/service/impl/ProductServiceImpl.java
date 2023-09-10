package com.example.similarproductsapirest.service.impl;

import com.example.similarproductsapirest.dto.ProductDetailDTO;
import com.example.similarproductsapirest.dto.SimilarProductsDTO;
import com.example.similarproductsapirest.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    private final String BASE_URL = "http://localhost:3001";

    private RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductDetailDTO getProductProductId(String productId) {
        String productDetailUrl = BASE_URL + "/product/" + productId;
        return restTemplate.getForObject(productDetailUrl, ProductDetailDTO.class);
    }

    @Override
    public SimilarProductsDTO getProductSimilarids(String productId) {
        String similarIdsUrl = BASE_URL + "/product/" + productId + "/similarids";
        return restTemplate.getForObject(similarIdsUrl, SimilarProductsDTO.class);
    }
}
