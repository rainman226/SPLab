package com.sp.persistance;

public interface CrudRepository<T, ID> {
    Iterable<T> save(Iterable<T> entities);
    Iterable<T> findById(Iterable<ID> ids);
    Iterable<T> findAll();
    void deleteById(Iterable<ID> ids);
    void delete(Iterable<T> entities);
    T save(T entity);
    T findById(ID id);
    void deleteById(ID id);

}