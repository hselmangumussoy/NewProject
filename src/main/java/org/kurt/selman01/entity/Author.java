package org.kurt.selman01.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;

   //@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    //cascade: bir entity üzerinde yapılan işlemlerin, bu entity'e bağlı ilişkili entity'ler üzerinde otomatik olarak uygulanmasını sağlar
   // public List<Book> bookList = new ArrayList<>();

    public Author() {
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
