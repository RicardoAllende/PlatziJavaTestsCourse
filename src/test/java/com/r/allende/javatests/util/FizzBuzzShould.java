package com.r.allende.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzShould {
    @Test
    public void passTests() {
//        assertEquals(FizzBuzz.fizzBuzz());
        assertEquals(FizzBuzz.fizzBuzz(3), "Fizz");
        assertEquals(FizzBuzz.fizzBuzz(6), "Fizz");
        assertEquals(FizzBuzz.fizzBuzz(5), "Buzz");
        assertEquals(FizzBuzz.fizzBuzz(10), "Buzz");
        assertEquals(FizzBuzz.fizzBuzz(15), "FizzBuzz");
        assertEquals(FizzBuzz.fizzBuzz(30), "FizzBuzz");
        assertEquals(FizzBuzz.fizzBuzz(2), "2");
        assertEquals(FizzBuzz.fizzBuzz(16), "16");
    }
}