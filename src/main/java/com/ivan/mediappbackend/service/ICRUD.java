package com.ivan.mediappbackend.service;

import com.ivan.mediappbackend.model.Patient;

import java.util.List;

public interface ICRUD<T, ID>{
    T save(T t);
    T update(T t, ID Id);
    List<T> findAll();
    T findById(ID id);
    void delete(ID id);
}
