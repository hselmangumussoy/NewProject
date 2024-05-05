package org.kurt.selman01.service;

import jakarta.persistence.EntityNotFoundException;
import org.kurt.selman01.dto.AuthorDto;
import org.kurt.selman01.dto.BookDto;
import org.kurt.selman01.entity.Author;
import org.kurt.selman01.entity.Book;
import org.kurt.selman01.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository bookRepository;
    AuthorService authorService;

    BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public BookDto save(BookDto bookDto) {
        Book book = toDto(bookDto);

        if (!authorService.isExist(book.name)){
            throw new EntityNotFoundException(bookDto.authorId +" yazar bulunamadı");
        }

        return toDto(bookRepository.save(book));
    }

    public Book get(int id) {
        return bookRepository.findById(id).get();
    }

    public String delete(int id) {
        if(bookRepository.findById(id).get() == null){
            return id +"'li yazar bulunamadı";
        }
        bookRepository.deleteById(id);
        return id +"'li yazar silindi";
    }

    public Book update(int bookId, Book newBook) {
        Book oldbook = bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException(bookId +"'li yazar bulunamadı")
        );
        oldbook.name = newBook.name;
        oldbook.pages = newBook.pages;
        return bookRepository.save(oldbook);
    }

    public Boolean checkBook(Book book) {
        //boolean primitive, metod yok; Boolean gelişmiş
        boolean isBook = bookRepository.existsById(book.id);
        if (!isBook) {
            throw new EntityNotFoundException(book.id+ "bulunamadı");
        }

        return isBook;
    }

    public  Book toDto(BookDto bookDto){
        Book book = new Book();
        book.setName(bookDto.name) ;
        book.setPages(bookDto.pages);
        return book;
    }

    public BookDto toEntity(Book book){

        BookDto bookDto= new BookDto();
        bookDto.name= book.getName();
        bookDto.pages =book.getPages();
        return bookDto;
    }
}
