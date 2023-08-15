package com.solutiscar.services;

import java.util.List;

public abstract class ServiceCrud<T> {

    public abstract T obterPorId(Long id);

    public abstract List<T> listarTodos();

    public abstract T insert(T obj);

    public abstract void excluirPorId(Long id);
}
