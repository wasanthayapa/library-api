package com.api.library.service.book;

import com.api.library.dto.author.AuthorDTO;
import com.api.library.dto.book.BookDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public interface BookService {

    List<BookDTO> getAll();

    Page<BookDTO> getAll(Integer pageNumber, Integer size);

    BookDTO findBookById(Integer id);

    BookDTO createBook(BookDTO dto);

    BookDTO updateBook(Integer bookId,BookDTO dto);
}
