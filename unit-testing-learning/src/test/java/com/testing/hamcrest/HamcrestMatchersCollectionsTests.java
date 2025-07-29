package com.testing.hamcrest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersCollectionsTests {

    @Test
    public void testCollectionEmpty() {

        var list = new ArrayList<>();
        assertThat(list, empty());
    }

    @Test
    public void testCollectionCertainSize() {

        var list = Arrays.asList("Alex", "Edi", "Florin");
        assertThat(list, hasSize(3));
    }

    @Test
    public void testCollectionContainsItem() {

        var list = Arrays.asList("Alex", "Edi", "Florin");
        assertThat(list, hasItem("Alex"));
    }

    @Test
    public void testCollectionContainsItems() {

        var list = Arrays.asList("Alex", "Edi", "Florin");
        assertThat(list, hasItems("Alex", "Edi"));
    }

    @Test
    public void testCollectionContainsItemsInOrder() {

        var list = Arrays.asList("Alex", "Edi", "Florin");
        assertThat(list, contains("Alex", "Edi", "Florin"));
    }

    @Test
    public void testCollectionContainsItemsInAnyOrder() {

        var list = Arrays.asList("Alex", "Edi", "Florin");
        assertThat(list, containsInAnyOrder("Alex", "Edi", "Florin"));
    }

    @Test
    public void testEveryItemMatches() {

        var list = Arrays.asList("Alex", "Andrei", "Alin");
        assertThat(list, everyItem(startsWith("A")));
    }

    @Test
    public void testMapHasKey() {

        var map = new HashMap<>();

        map.put("Alex", 23);
        map.put("Edi", 19);
        map.put("Florin", 22);

        assertThat(map, hasKey("Alex"));
    }

    @Test
    public void testMapHasValue() {

        var map = new HashMap<>();

        map.put("Alex", 23);
        map.put("Edi", 19);
        map.put("Florin", 22);

        assertThat(map, hasValue(23));
    }

    @Test
    public void testMapHasEntry() {

        var map = new HashMap<>();

        map.put("Alex", 23);
        map.put("Edi", 19);
        map.put("Florin", 22);

        assertThat(map, hasEntry("Alex", 23));
    }
}
