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
        emptyOptional.orElseThrow(IllegalArgumentException::new);

    }
}
