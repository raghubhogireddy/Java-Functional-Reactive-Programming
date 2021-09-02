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
   Constructor Reference we can invoke as Method Reference
   `Ex : r -> new Thread(r) => Thread :: new `
