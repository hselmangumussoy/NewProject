package org.kurt.selman01.controller;

import org.kurt.selman01.dto.AuthorDto;
import org.kurt.selman01.request.AuthorRequest;
import org.kurt.selman01.response.AuthorResponse;
import org.kurt.selman01.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    AuthorService authorService;
    AuthorController (AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public AuthorResponse save(@RequestBody AuthorRequest author) {
        return toResponse(authorService.save(toDto(author)));
    }

    @GetMapping("{id}")
    public AuthorResponse get(@PathVariable int id) {
        return toResponse(authorService.get(id));
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        return authorService.delete(id);
    }

    @PutMapping("{id}")
    public AuthorResponse update(@PathVariable int id, @RequestBody AuthorRequest newAuthor) {
        return toResponse(authorService.update(id, toDto(newAuthor)));
    }

    private AuthorDto toDto(AuthorRequest request){
        AuthorDto authorDto = new AuthorDto();
        authorDto.age = request.age;
        authorDto.name = request.name;
        return authorDto;
    }

    private AuthorResponse toResponse(AuthorDto dto){
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.id = dto.id;
        authorResponse.name = dto.name;
        authorResponse.age = dto.age;
        return authorResponse;
    }
}
