package ru.diasoft.micro.dofacade.converter;

public interface Converter<T, R> {
    R createFrom(T obj);
}
