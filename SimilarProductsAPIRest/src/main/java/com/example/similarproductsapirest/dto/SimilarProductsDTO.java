package com.example.similarproductsapirest.dto;

import java.util.Set;

public class SimilarProductsDTO {

    private Set<String> similarProductsId;

    public SimilarProductsDTO() {
    }

    public SimilarProductsDTO(Set<String> similarProductsId) {
        this.similarProductsId = similarProductsId;
    }

    public Set<String> getSimilarProductsId() {
        return similarProductsId;
    }

    public void setSimilarProductsId(Set<String> similarProductsId) {
        this.similarProductsId = similarProductsId;
    }
}
