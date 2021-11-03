package com.r.allende.javatests.util;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static String fizzBuzz(Integer n) {
//        Si el número es divisible por 3, retorna “Fizz”
//        Si el número es divisible por 5, retorna “Buzz”
//        Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
//        En otro caso, retorna el mismo número
//        String response = n.toString();
//        List<String> pieces = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        if (IsDivisibleBy.handle(n, 3)) {
            stringBuilder.append("Fizz");
//            pieces.add("Fizz");
        }
        if (IsDivisibleBy.handle(n, 5)) {
            stringBuilder.append("Buzz");
//            pieces.add("Buzz");
        }

        return (stringBuilder.length() > 0) ? stringBuilder.toString() : n.toString();
    }
}
