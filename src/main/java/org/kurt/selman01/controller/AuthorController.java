package org.kurt.selman01.controller;

import org.kurt.selman01.dto.AuthorDto;
import org.kurt.selman01.entity.Author;
import org.kurt.selman01.entity.Book;
import org.kurt.selman01.response.AuthorResponse;
import org.kurt.selman01.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    AuthorService authorService;
    AuthorController (AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public AuthorResponse save(@RequestBody AuthorDto author) {
        AuthorDto result = authorService.save(author);
        AuthorResponse response = new AuthorResponse();
        response.authorDto = result;
        return response;
    }

    @GetMapping("{id}")
    public Author get(@PathVariable int id) {

        return authorService.get(id);
    }


    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        return authorService.delete(id);
    }

    @PutMapping("{id}")
    public Author update(@PathVariable int id, @RequestBody Author newAuthor) {
        return authorService.update(id, newAuthor);
    }





}
