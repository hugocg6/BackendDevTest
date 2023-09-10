package com.example.similarproductsapirest.controller;

import com.example.similarproductsapirest.dto.ProductDetailDTO;
import com.example.similarproductsapirest.dto.SimilarProductsDTO;
import com.example.similarproductsapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}/similar")
    public SimilarProductsDTO getSimilarProducts(@PathVariable String productId) {
        SimilarProductsDTO similarProducts = productService.getProductSimilarIds(productId);

        for (String similarProductId : similarProducts.getSimilarProductsId()) {
            ProductDetailDTO productDetail = productService.getProductProductId(similarProductId);
        }

        return similarProducts;
    }
}
