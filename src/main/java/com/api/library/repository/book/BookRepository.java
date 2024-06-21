package com.api.library.repository.book;

import com.api.library.entity.author.Author;
import com.api.library.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public interface BookRepository extends JpaRepository<Book,Integer> {
}
