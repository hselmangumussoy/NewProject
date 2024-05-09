package org.kurt.selman01.service;

import jakarta.persistence.EntityNotFoundException;
import org.kurt.selman01.dto.AuthorDto;
import org.kurt.selman01.dto.BookDto;
import org.kurt.selman01.entity.Book;
import org.kurt.selman01.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository repository;
    AuthorService authorService;

    BookService(BookRepository bookRepository, AuthorService authorService) {
        this.repository = bookRepository;
        this.authorService = authorService;
    }

    public BookDto save(BookDto dto) {
        Book newBook = toEntity(dto);
        repository.save(newBook);
        return toDto(newBook);
    }

    public BookDto get(int id) {
        Book book = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id +"'li kitap bulunamadı")
        );
        return toDto(book);
    }

    public String delete(int id) {
        if(repository.findById(id).get() == null){
            return id +"'li kitap bulunamadı";
        }
        repository.deleteById(id);
        return id +"'li kitap silindi";
    }

    public BookDto update(int bookId, BookDto newBook) {
        Book oldbook = repository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException(bookId +"'li kitap bulunamadı")
        );
        oldbook = setBook(oldbook, newBook);
        repository.save(oldbook);
        return toDto(oldbook);
    }

    private Book setBook(Book oldbook, BookDto newBook) {
        oldbook.name = newBook.name;
        oldbook.pages = newBook.pages;
        oldbook.authorId = newBook.author.id;
        return oldbook;
    }

    public BookDto toDto(Book book){
        BookDto dto = new BookDto();
        dto.id = book.id;
        dto.name = book.name;
        dto.pages = book.pages;
        dto.author.id = book.authorId;
        return dto;
    }

    public Book toEntity(BookDto dto){
        Book book = new Book();
        book.name = dto.name;
        book.pages = dto.pages;
        AuthorDto authorDto = authorService.get(dto.author.id);
        book.authorId = authorDto.id;
        return book;
    }
}
