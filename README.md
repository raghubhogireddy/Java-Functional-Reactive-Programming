# Java-Functional-Reactive-Programming

**Function** : 
1. Access Modifier
2. ReturnType
3. Name of the  Function
4. Parameter List and Parameters Type
5. Method Body
6. Return Statement

**Lambda** :
1. A list of Parameters
2. An Arrow ->  which seperates  the list of  parameters from body of lambda
3. The  body of  lambda

**Most used  Functional Interfaces**
1. Predicate : Tests Condition
2. Consumer : Takes/Consume something
3. Function : Takes something returns nothing
4. Supplier : Supplies/Return something

Generally Function is used  for Transformation

### Method & Constructor Reference

1. **object :: instanceMethod** <br>
   Method Reference to an instance method of an existing object <br>
   `Ex : e -> System.out.println(e) => System.out :: println;`
2. **Class :: staticMethod** <br>
   Method Reference to a static method of a  class <br>
   `Ex : Math.Random() => Math :: Random;`
3. **Class :: instanceMethod** <br>
   Method Reference to an instance method of an input object of particular type <br>
   `Ex : s -> s.length() => String :: length`
4. **Class :: New** <br>
   Constructor Reference we can invoke as Method Reference <br>
   `Ex : r -> new Thread(r) => Thread :: new `

### Optional

Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. 

**_Creating Optional_**

`String val = "Sample";` <br>
`Optional<String> s = Optional.of(val);`

**_empty Optional_**

`Optional<Integer> empty = Optional.empty();`

**_Creating Nullable_**

`Optional<String> stringOptional = Optional.ofNullable(val);` <br>
`Optional<String> emptyOptional = Optional.ofNullable(null);`

**few methods on top of Optional**
`get()` -> get the value from Optional<br>
`isPresent(consumer)` -> checks if value present inside optional<br>
`orElse(other)` -> return other if optional was empty<br>
`orElseGet(Supplier)` -> return the supplier if optional was empty<br>
`orElseThrow(exceptionSupplier)` -> Return the exception that we provide when optional was empty<br>
`orElseThrow()` -> introduced in Java 10. and it was simultaneously equal to `get()`<br>

**few important methods to play with Optionals**

`map(), filter(), flatMap()`
