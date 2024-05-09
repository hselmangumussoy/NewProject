package org.kurt.selman01.request;

public class BookRequest {
    public String name;
    public int pages;
    public int authorId;

    public BookRequest() {

    }

    public BookRequest(String name, int pages, int authorId){
        this.name = name;
        this.pages = pages;
        this.authorId = authorId;
    }
}
