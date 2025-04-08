package com.testing.junit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private String brandName;
    private String model;
    private Integer id;
    private Double price;
    private String category;
}
