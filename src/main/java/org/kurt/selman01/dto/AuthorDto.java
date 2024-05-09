package org.kurt.selman01.dto;

public class AuthorDto {
    public int id;
    public String name;
    public int age;

    public AuthorDto() {

    }

    public AuthorDto(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
