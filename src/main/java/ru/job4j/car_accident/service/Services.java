package ru.job4j.car_accident.service;

import java.util.List;

public interface Services<T> {

    void save(T entity);

    List<T> getAll();

    T findById(int id);

    void update(T entity);
}
