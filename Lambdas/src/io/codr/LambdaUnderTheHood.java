package io.codr;

public class LambdaUnderTheHood {
    public static void main(String[] args) {

        /*MyInterface myInterface = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("Impl 1");
            }
        };

        MyInterface myInterface2 = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("Impl 2");
            }
        };*/

        MyInterface myInterface = ()-> System.out.println("I'm  light  weight");



    }
}
