package org.kurt.selman01.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String bookKod;
    public String name;
    public int pages;
    public int authorId;

    public Book() {
        this.bookKod = this.id + "" + this.name;
    }
}
