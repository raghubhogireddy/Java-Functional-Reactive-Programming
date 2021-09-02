package io.codr.optional;

import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.Optional;

public class OptionalCreation {
    public static void main(String[] args) {

        String val = "Sample" ;
        Optional<String> s = Optional.of(val);

        System.out.println(s.get());

        // empty
        Optional<Integer> empty = Optional.empty();

        //Nullable
        Optional<String> stringOptional = Optional.ofNullable(val);
        Optional<String> emptyOptional = Optional.ofNullable(null);

        //isPresent
        System.out.println(emptyOptional.isPresent() ? emptyOptional.get() : 0);

        // orElse , orElseGet
        System.out.println(emptyOptional.isPresent() ? emptyOptional.get() : emptyOptional.orElse("0"));
        System.out.println(emptyOptional.isPresent() ? emptyOptional.get()
                : emptyOptional.orElseGet(() -> "0"));

        // orElseThrow
       // emptyOptional.orElseThrow(IllegalArgumentException::new);

        // map()
        String map = s.map(s1 -> "changed").orElse("Empty");
        System.out.println(map);

        // filter()
        Optional<String> filter = s.filter(s1 -> s1.equalsIgnoreCase(val));
        System.out.println(filter);

        //flatMap()
        Optional<String> flatMap = s.flatMap(s1 -> Optional.of(val));
        System.out.println(flatMap);

        // isPresent
        Optional<String> optional = Optional.of("Some Value");
        optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(System.out::println,()-> System.out.println("value absent"));
        Optional.empty().ifPresentOrElse(System.out::println,()-> System.out.println("value absent"));

        //stream
        optional.stream().forEach(System.out::println);
        Optional.empty().stream().forEach(System.out::println);

        // or
        optional.or(() -> Optional.of("New Value")).ifPresent(System.out::println);
        Optional.empty().or(() -> Optional.of("New Value")).ifPresent(System.out::println);

        //equals
        //optional
        // either both are empty
        // or if values in optional are equal via  equals method
        System.out.println(optional.equals(Optional.of("SomeOther")));

        //hashCode
        System.out.println(s.hashCode());



    }
}
