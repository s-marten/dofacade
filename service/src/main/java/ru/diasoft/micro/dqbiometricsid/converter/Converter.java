package ru.diasoft.micro.dqbiometricsid.converter;

public interface Converter<T, R> {
    R createFrom(T obj);
}
