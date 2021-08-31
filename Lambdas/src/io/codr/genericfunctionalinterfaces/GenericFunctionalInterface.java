package io.codr.genericfunctionalinterfaces;

@FunctionalInterface
public interface GenericFunctionalInterface<T,R> {
    R execute(T t);
}
