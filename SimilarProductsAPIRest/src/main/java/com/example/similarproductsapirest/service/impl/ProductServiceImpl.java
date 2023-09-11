package com.example.similarproductsapirest.service.impl;

import com.example.similarproductsapirest.dto.ProductDetailDTO;
import com.example.similarproductsapirest.dto.SimilarProductsDTO;
import com.example.similarproductsapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${app.client.url}")
    private static String baseUrl;

    @Value("${app.client.path}")
    private static String path;

    private RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductDetailDTO getProductProductId(String productId) {
        String productDetailUrl = baseUrl + productId;
        return restTemplate.getForObject(productDetailUrl, ProductDetailDTO.class);
    }

    @Override
    public SimilarProductsDTO getProductSimilarIds(String productId) {
        String similarIdsUrl = baseUrl + productId + path;
        return restTemplate.getForObject(similarIdsUrl, SimilarProductsDTO.class);
    }
}
