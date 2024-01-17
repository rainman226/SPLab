package com.sp.components.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sp.commands.*;
import com.sp.book.Book;
import com.sp.book.MyPair;
import com.sp.persistance.*;
import com.sp.helpers.BookStatistics;
import com.sp.helpers.CommandExecutor;
//import com.sp.helpers.filters.commands.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final Command<Iterable<Book>, Void> getAll;
    private final Command<Book, String> getOne;
    private final Command<Book, Book> addOne;
    private final Command<Book, MyPair<String,Book>> updateOne;
    private final Command<Void, String> deleteOne;
    private final CommandExecutor commandExecutor;

    public BooksController(CrudRepository<Book, Integer> repository,
                           CommandExecutor commandExecutor){

//        var repository = new JPACrudRepository<>(booksRepository);

        getAll = new GetAllCommand<Book>(repository);
        getOne = new FindOneCommand<Book>(repository);
        addOne = new AddOneCommand<Book>(repository);
        updateOne = new UpdateOneCommand<Book>(repository);
        deleteOne = new DeleteOneCommand<Book>(repository);
        this.commandExecutor = commandExecutor;
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> printStatistics() {
        var books = getAll.execute();
        if(books.iterator().hasNext())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        var book = books.iterator().next();
        BookStatistics stats = new BookStatistics();
        book.accept(stats);
        return new ResponseEntity<>(stats.getStatistics(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks() {
        Iterable<Book> books = commandExecutor.execute(getAll);
        return new ResponseEntity<>(books, HttpStatus.OK);
//        return new ResponseEntity<>(commandExecutor.executeAsync(getAll), HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable String id) {
        try{
            getOne.setCommandContext(id);
            Book book = commandExecutor.execute(getOne);
            return new ResponseEntity<>(book, HttpStatus.OK);
            //        getOne.setCommandContext(id);
//        return new ResponseEntity<>(commandExecutor.executeAsync(getOne), HttpStatus.ACCEPTED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        addOne.setCommandContext(book);
        Book insertedBook =  commandExecutor.execute(addOne);
        return new ResponseEntity<>(insertedBook, HttpStatus.OK);
//        addOne.setCommandContext(book);
//        return new ResponseEntity<>(commandExecutor.executeAsync(addOne), HttpStatus.ACCEPTED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putBook(@PathVariable String id, @RequestBody Book book) {
        MyPair<String,Book> pair = new MyPair<String, Book>(id, book);
        updateOne.setCommandContext(pair);
        Book updatedBook = commandExecutor.execute(updateOne);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
//        MyPair<String,Book> pair = new MyPair<>(id, book);
//        updateOne.setCommandContext(pair);
//        return new ResponseEntity<>(commandExecutor.executeAsync(updateOne), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        deleteOne.setCommandContext(id);
        commandExecutor.execute(deleteOne);
        return new ResponseEntity<>("Removed!", HttpStatus.OK);
//        deleteOne.setCommandContext(id);
//        return new ResponseEntity<>(commandExecutor.executeAsync(deleteOne), HttpStatus.ACCEPTED);
    }

    @GetMapping("/async/{opId}")
    public ResponseEntity<?> getAsyncResult(@PathVariable String opId){
        return new ResponseEntity<>( commandExecutor.getAsyncResult(opId), HttpStatus.OK);
    }


}