package org.kurt.selman01.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int pages;
    private int authorId;

   /* @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public  Author author;*/

    public Book(int id, String name, int pages, int authorId) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
