package br.com.clinica.repositorios;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void delete(T entity);
    boolean exists(ID id);
}
