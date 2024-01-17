package com.sp.persistance;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sp.book.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component()
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JPACrudRepository<T, Id> implements CrudRepository<T, Id> {
    private final JpaRepository<T, Id> repository;

    public JPACrudRepository(JpaRepository<T, Id> repository) {
        this.repository = (JpaRepository<T, Id>)repository;
    }

    @Override
    public Iterable<T> save(Iterable<T> entities) {
        List<T> savedEntities = new ArrayList<>();
        for (T entity : entities) {
            savedEntities.add(repository.save(entity));
        }
        return savedEntities;
    }

    @Override
    public Iterable<T> findById(Iterable<Id> ids) {
        List<T> foundEntities = new ArrayList<>();
        for (Id id : ids) {
            Optional<T> optionalEntity = repository.findById(id);
            optionalEntity.ifPresent(foundEntities::add);
        }
        return foundEntities;
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Iterable<Id> ids) {
        for (Id id : ids) {
            repository.deleteById(id);
        }
    }

    @Override
    public void delete(Iterable<T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public T save(T entity) {
        repository.save(entity);
        return  entity;
    }

    @Override
    public T findById(Id id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Id id) {
        repository.deleteById(id);
    }
}