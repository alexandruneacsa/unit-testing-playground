package com.testing.junit.product;

import com.testing.junit.model.Product;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class ProductFourthTestClass {

    static Product tv;

    @BeforeAll
    static void init() {

        tv = new Product("Samsung",
                "SmartTv", 1, 1000.0, "TV");
    }

    @Test
    @Timeout(1)
    @Tag("TEST")
    void brandTest() {

        assertEquals("Samsung", tv.getBrandName());
    }

    @Test
    @Timeout(1)
    @Tag("DEV")
    void categoryTest() {

        assertEquals("TV", tv.getCategory());
    }

    @Test
    @Timeout(1)
    @Tag("TEST")
    void priceTest() {

        assertEquals(1000, tv.getPrice());
    }

    @Test
    @Timeout(1)
    @Tag("DEV")
    void modelTest() {

        assertEquals("SmartTv", tv.getModel());
    }

    @Test
    @Timeout(1)
    @Tag("TEST")
    void idTest() {

        assertEquals(1, tv.getId());
    }
}
