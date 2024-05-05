package org.kurt.selman01.repository;

import org.kurt.selman01.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {


}
