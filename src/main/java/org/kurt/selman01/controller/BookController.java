package org.kurt.selman01.controller;

import org.kurt.selman01.dto.BookDto;
import org.kurt.selman01.entity.Author;
import org.kurt.selman01.entity.Book;
import org.kurt.selman01.response.BookResponse;
import org.kurt.selman01.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController//Spring MVC controller sınınıfının RESTful web servisi olarak işlev göreceğini belirtir. Yani, bu sınıfın içindeki metodlar HTTP isteklerine cevap verecek ve genellikle JSON veya XML gibi veri formatlarını kullanarak ver döndürecektir.
@RequestMapping("/books")//Bir controller sınıfında veya yönteminde belirli bir HTTP isteği metoduna karşılık gelen bir URL yolu (endpoint) belirler.
public class BookController {
    BookService bookService;
    BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookResponse save(@RequestBody BookDto bookDto) {
        BookDto result = bookService.save(bookDto);
        BookResponse response = new BookResponse();
        response.bookDto = result;
        return response;
    }

    @PostMapping("/checkBook")
    public Boolean checkBook(@RequestBody Book book){
        return bookService.checkBook(book);
    }

    @GetMapping("{id}")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        return bookService.delete(id);
    }

    @PutMapping("{id}")
    public Book update(@PathVariable int id, @RequestBody Book newBook) {
        return bookService.update(id, newBook);
    }
}
