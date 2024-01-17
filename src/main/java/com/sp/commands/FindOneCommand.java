package com.sp.commands;

import com.sp.book.Repository;
import lombok.Setter;
import com.sp.persistance.*;

public class FindOneCommand<T> implements Command<T, String> {
    private final CrudRepository<T, Integer> repository;
    @Setter
    private String commandContext;

    public FindOneCommand(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }
    private FindOneCommand(FindOneCommand<T> foc) {
        this.repository = foc.repository;
        this.commandContext = foc.commandContext;
    }

    @Override
    public T execute() {
        return repository.findById(Integer.parseInt(commandContext));
    }

    @Override
    public Command<T, String> getClone() {
        return new FindOneCommand<>(this);
    }
}