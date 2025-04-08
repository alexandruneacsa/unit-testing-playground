package com.testing.junit.product;

import com.testing.junit.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductThirdTestClass {

    static Product tv;

    @BeforeAll
    static void init() {

        tv = new Product("Samsung",
                "SmartTv", 1, 1000.0, "TV");
    }

    @ProductCustomTestConditions
    @DisplayName("Test brand")
    void brandTest() {
        assertEquals("Samsung", tv.getBrandName());
    }
}
