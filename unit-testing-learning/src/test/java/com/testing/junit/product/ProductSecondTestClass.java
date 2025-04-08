package com.testing.junit.product;

import com.testing.junit.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSecondTestClass {

    static Product tv;

    @BeforeAll
    static void init() {

        tv = new Product("Samsung",
                "SmartTv", 1, 1000.0, "TV");
    }

    @Test
    @Order(1)
    @DisplayName("Test name")
    @EnabledIfSystemProperty(named = "os.arch", matches = "x86_64")
    void brandTest() {

        assertEquals("Samsung", tv.getBrandName());
    }

    @Test
    @Order(2)
    @DisplayName("Test category")
    @EnabledIfSystemProperty(named = "os.version", matches = "10\\..*")
    void categoryTest() {

        assertEquals("TV", tv.getCategory());
    }

    @Test
    @Order(3)
    @DisplayName("Test price")
    @DisabledIfSystemProperty(named = "os.name", matches = "Windows 10")
    void priceTest() {

        assertEquals(1000, tv.getPrice());
    }

    @Test
    @Order(4)
    @DisplayName("Test model")
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*_64")
    void modelTest() {

        assertEquals("SmartTv", tv.getModel());
    }

    @Test
    @Order(5)
    @DisplayName("Test id")
    @EnabledIfEnvironmentVariable(named = "PWD", matches = ".*unit.*")
    void idTest() {

        assertEquals(1, tv.getId());
    }
}
