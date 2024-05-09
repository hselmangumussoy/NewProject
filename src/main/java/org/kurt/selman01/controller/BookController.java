package org.kurt.selman01.controller;

import org.kurt.selman01.dto.BookDto;
import org.kurt.selman01.entity.Author;
import org.kurt.selman01.entity.Book;
import org.kurt.selman01.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;
    BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDto save(@RequestBody BookDto book) {
        return bookService.save(book);
    }

    @GetMapping("{id}")
    public BookDto get(@PathVariable int id) {
        return bookService.get(id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        return bookService.delete(id);
    }

    @PutMapping("{id}")
    public BookDto update(@PathVariable int id, @RequestBody BookDto newBook) {
        return bookService.update(id, newBook);
    }
}
