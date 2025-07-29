package com.testing.hamcrest;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersNumericTests {

    @Test
    public void testEqualTo() {

        assertThat(200, equalTo(200));
    }

    @Test
    public void testGreaterThan100() {

        assertThat(199, greaterThan(100));
    }

    @Test
    public void testLessThan100() {

        assertThat(99, lessThanOrEqualTo(100));
    }

    @Test
    public void testCloseTo() {

        assertThat(99.5, closeTo(100, 0.5));
    }

    @Test
    public void testBetween() {

        assertThat(250, allOf(greaterThanOrEqualTo(200), lessThanOrEqualTo(300)));
    }

    @Test
    public void testEither() {

        assertThat(200, either(equalTo(200)).or(equalTo(201)));
    }
}
