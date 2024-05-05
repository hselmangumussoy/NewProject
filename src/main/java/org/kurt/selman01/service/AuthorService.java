package org.kurt.selman01.service;

import jakarta.persistence.EntityNotFoundException;
import org.kurt.selman01.dto.AuthorDto;
import org.kurt.selman01.entity.Author;
import org.kurt.selman01.entity.Book;
import org.kurt.selman01.repository.AuthorRepository;
import org.kurt.selman01.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    AuthorRepository authorRepository;
    AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public AuthorDto save(AuthorDto authorDto) {
        Author author = toEntity(authorDto);
        author = authorRepository.save(author);
        return toDto(author);
    }
    public Author get(int id) {
        return authorRepository.findById(id).get();
    }

    public String delete(int id) {
        if(authorRepository.findById(id).get() == null){
            return id +"'li yazar bulunamadı";
        }
        authorRepository.deleteById(id);
        return id +"'li yazar silindi";
    }

    public Author update(int authorId, Author author) {
        Author oldAuthor = authorRepository.findById(authorId).orElseThrow(
                () -> new EntityNotFoundException(authorId +"'li yazar bulunamadı")
        );
        oldAuthor.getName() = author.getName();
        oldAuthor.getAge() = author.getAge();
        return authorRepository.save(oldAuthor);
    }

    public boolean isExist(int authorId){
        return  authorRepository.existsById(authorId);
    }

    public  Author toEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setAge(authorDto.age);
        author.setName(authorDto.name);

        return author;
    }

    public AuthorDto toDto(Author author){

        AuthorDto authorDto= new AuthorDto();
        authorDto.age = author.getAge();
        authorDto.name =author.getName();
        return authorDto;
    }
}
