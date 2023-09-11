package com.example.similarproductsapirest.controller;

import com.example.similarproductsapirest.dto.ProductDetailDTO;
import com.example.similarproductsapirest.dto.SimilarProductsDTO;
import com.example.similarproductsapirest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDetailDTO>> getSimilarProducts(@PathVariable String productId) {
        try {
            SimilarProductsDTO similarProductsIds = productService.getProductSimilarIds(productId);

            List<ProductDetailDTO> similarProducts = new ArrayList<>();

            for (String similarProductId : similarProductsIds.getSimilarProductsId()) {
                ProductDetailDTO productDetail = productService.getProductProductId(similarProductId);
                similarProducts.add(productDetail);
            }

            return ResponseEntity.ok(similarProducts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
