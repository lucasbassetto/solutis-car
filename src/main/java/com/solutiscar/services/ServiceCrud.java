package com.solutiscar.services;

import java.util.List;

public abstract class ServiceCrud<T> {

    abstract T obterPorId(Long id);

    abstract List<T> listarTodos();

    abstract T insert(T obj);

    abstract void excluirPorId(Long id);
}
