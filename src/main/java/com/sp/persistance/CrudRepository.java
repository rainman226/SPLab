package com.sp.persistance;


import java.util.List;

public interface CrudRepository<T, TId> {
    List<T> findAll();
    T findById(TId id);
    T save(T other);
    void deleteById(TId id);
    public T update(Long id, T updatingBook);
}