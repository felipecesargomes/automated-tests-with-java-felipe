package br.com.felipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraysCompareTest {

    @Test
    void test() {
        int[] numbers = {25,8,21,32,3};
        int[] expectedArrays = {3,8,21,25,32};

        Arrays.sort(numbers);

        assertArrayEquals(numbers, expectedArrays);

    }

    @Test
    //@Timeout(1)
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance() {

        int[] numbers = {25,8,21,32,3};
        for(int i = 0; i < 1000000000; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }

        //assertArrayEquals(numbers, expectedArrays);

    }

}