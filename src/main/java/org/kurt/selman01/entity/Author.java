package org.kurt.selman01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public int age;

    public Author() {
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
