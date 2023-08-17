package com.solutiscar.services;

import java.util.List;

public abstract class ServiceCrud<T> {

    public abstract T findById(Long id);

    public abstract List<T> listAll();

    public abstract T insert(T obj);

    public abstract void deleteById(Long id);

}
