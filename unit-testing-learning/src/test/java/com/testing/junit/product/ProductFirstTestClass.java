package com.testing.junit.product;

import com.testing.junit.model.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Random.class)
public class ProductFirstTestClass {

    static Product tv;

    @BeforeAll
    static void init() {

        tv = new Product("Samsung",
                "SmartTv", 1, 1000.0, "TV");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Test name")
    void brandTest() {

        assertEquals("Samsung", tv.getBrandName());
    }

    @Test
    @DisplayName("Test category")
    @EnabledOnOs(OS.MAC)
    void categoryTest() {

        assertEquals("TV", tv.getCategory());
    }

    @Test
    @DisabledOnOs(OS.MAC)
    @DisplayName("Test price")
    void priceTest() {

        assertEquals(2000, tv.getPrice());
    }

    @Test
    @DisplayName("Test model")
    @EnabledOnJre(JRE.JAVA_21)
    void modelTest() {

        assertEquals("SmartTv", tv.getModel());
    }

    @Test
    @DisplayName("Test id")
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_20)
    void idTest() {

        assertEquals(1, tv.getId());
    }
}
