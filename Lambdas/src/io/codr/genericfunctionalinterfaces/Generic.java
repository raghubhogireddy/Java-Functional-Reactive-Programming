package io.codr.genericfunctionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Generic {
    public static void main(String[] args) {

         predicateFunctionality();
         ConsumerFunctionality();
         supplierFunctionality();
         functionFunctionality();
         unaryOperatorFunctionality();
         biFunctionFunctionality();
         binaryOperatorFunctionality();



    }

    private static void binaryOperatorFunctionality() {
        BinaryOperator<String> operator = (a,b) -> a + "." + b;
        System.out.println(operator.apply("Raghu", "Ram"));
    }

    private static void biFunctionFunctionality() {
        BiFunction<String,String,Integer> function = (a,b) -> (a+b).length();
        System.out.println(function.apply("Raghu","Ram"));
    }

    private static void unaryOperatorFunctionality() {
        List<Integer> integers = List.of(34,67,78,23,89,45,90);
        UnaryOperator<Integer> operator = integer -> integer * 100;
        List<Integer> mapper = mapper(integers, operator);
        System.out.println(mapper);
    }

    private static <T> List<T> mapper(List<T> integers, UnaryOperator<T> operator) {
        List<T> tempList = new ArrayList<>();
        for (T t : integers){
            tempList.add(operator.apply(t));
        }
        return tempList;
    }

    private static void functionFunctionality() {

        List<String> list = List.of("Raghu", "Rajesh" ,"RaghuRam", "Rakesh", "");
        Function<String,Integer> function = String::length;

        List<Integer> integers = map(list,function);
        System.out.println(integers);
    }

    private static <T,R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> tempList = new ArrayList<>();
        for (T  t : list){
            tempList.add(function.apply(t));
        }
        return tempList;
    }

    private static void supplierFunctionality() {
        Supplier<String> stringSupplier = () -> new String("A String");
        System.out.println(stringSupplier.get());

        Supplier<Double> doubleSupplier = Math::random;
        System.out.println(doubleSupplier.get());

    }

    private static void ConsumerFunctionality() {
        List<Integer> integers = List.of(34,67,78,23,89,45,90);
        Consumer<Integer> consumer = integer -> System.out.print(integer + ", ");
        printElement(integers,consumer);
    }

    private static <T> void printElement(List<T> integers, Consumer<T> consumer) {
        for (T t : integers){
            consumer.accept(t);
        }
    }

    private static void predicateFunctionality() {
        GenericFunctionalInterface<String, String> anInterface = s-> s.substring(0,9);
        System.out.println(anInterface.execute("RaghuramBhogireddy"));

        GenericFunctionalInterface<String, Integer> anInterface1 = String::length;
        System.out.println(anInterface1.execute("RaghuramBhogireddy"));


        List<String> list  = new ArrayList<>();
        list.add("Raghu");
        list.add("Rajesh");
        list.add("RaghuRam");
        list.add("Rakesh");
        list.add("");

        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> filterList = filterList(list,predicate);
        System.out.println(filterList);


        List<Integer> integers = List.of(2,4,6,7,8,1,90);
        Predicate<Integer> integerPredicate  = e -> e % 2 == 0;
        List<Integer> integerList = filterList(integers, integerPredicate);
        System.out.println(integerList);
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> tempList = new ArrayList<>();
        for (T element : list){
            if (predicate.test(element))
                tempList.add(element);
        }
        return tempList;
    }
}
