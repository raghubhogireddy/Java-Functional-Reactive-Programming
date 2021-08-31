package io.codr;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {
    public static void main(String[] args) {

        // Imperative
        int sumOfEvens = 0;
        for (int i = 0 ; i <= 100; i++){
            if(i%2 == 0){
                sumOfEvens = sumOfEvens + i;
            }
        }
        System.out.println("Imperative : " + sumOfEvens);

        // Declarative
        sumOfEvens = IntStream.rangeClosed(0,100)
                .filter(i -> i % 2 == 0)
                .reduce(Integer :: sum)
                .getAsInt();


        System.out.println("Declarative : " + sumOfEvens);

    }
}
