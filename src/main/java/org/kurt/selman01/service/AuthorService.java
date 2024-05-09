package org.kurt.selman01.service;

import jakarta.persistence.EntityNotFoundException;
import org.kurt.selman01.dto.AuthorDto;
import org.kurt.selman01.entity.Author;
import org.kurt.selman01.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    AuthorRepository repository;
    AuthorService(AuthorRepository authorRepository) {
        this.repository = authorRepository;
    }
    public AuthorDto save(AuthorDto dto) {
        Author author = toEntity(dto);
        repository.save(author);
        return toDto(author);
    }

    public AuthorDto get(int id) {
        Author author = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(id +"'li yazar bulunamadı"));
        return toDto(author);
    }

    public String delete(int id) {
        if(repository.findById(id).get() == null){
            return id +"'li yazar bulunamadı";
        }
        repository.deleteById(id);
        return id +"'li yazar silindi";
    }

    public AuthorDto update(int authorId, AuthorDto author) {
        Author oldAuthor = repository.findById(authorId).orElseThrow(
                () -> new EntityNotFoundException(authorId +"'li yazar bulunamadı")
        );
        oldAuthor = setAuthor(oldAuthor, author);
        repository.save(oldAuthor);
        return toDto(oldAuthor);
    }

    private Author setAuthor(Author oldAuthor, AuthorDto author) {
        oldAuthor.name = author.name;
        oldAuthor.age = author.age;
        return oldAuthor;
    }

    public AuthorDto toDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.id = author.id;
        dto.name = author.name;
        dto.age = author.age;
        return dto;
    }

    public Author toEntity(AuthorDto dto){
        Author author = new Author();
        author.name = dto.name;
        author.age = dto.age;
        return author;
    }
}
