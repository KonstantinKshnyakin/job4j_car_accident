package ru.job4j.car_accident.repository;

import java.util.List;

public interface MemStore<T> {

    void save(T entity);

    List<T> getAll();

    T findById(int id);

    void update(T entity);
}
