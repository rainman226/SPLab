package com.sp.commands;

import com.sp.book.Repository;

import java.util.List;
import com.sp.persistance.*;
public class GetAllCommand<T> implements Command<Iterable<T>, Void> {
    private final CrudRepository<T, Integer> repository;
    public GetAllCommand(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }
    private GetAllCommand(GetAllCommand<T> gac) {
        this.repository = gac.repository;
    }

    @Override
    public Iterable<T> execute() {
        return repository.findAll();
    }

    @Override
    public Command<Iterable<T>, Void> getClone() {
        return new GetAllCommand<>(this);
    }
}