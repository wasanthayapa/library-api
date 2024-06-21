package com.api.library.controller.book;

import com.api.library.dto.author.AuthorDTO;
import com.api.library.dto.book.BookDTO;
import com.api.library.service.author.AuthorService;
import com.api.library.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    /***
     *
     * @return List of Book register in system
     */
    @GetMapping
    private ResponseEntity<List<BookDTO>> getAllBook(){
        List<BookDTO> list=bookService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    /**
     *
     * @param id registered Book id
     * @return Details of Registered Book
     *
     */
    @GetMapping("/{id}")
    private ResponseEntity<BookDTO> getBookById(@PathVariable("id")Integer id){
        BookDTO dto=bookService.findBookById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }

    /**
     *
     * @param dto required data for Book registration
     * @return Registered book
     *
     */

    @PostMapping
    private ResponseEntity<BookDTO> createBook(@RequestBody BookDTO dto){
        BookDTO bookDTO=bookService.createOrUpdateBook(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDTO);
    }

    /**
     *
     * @param dto updated data for Book
     * @return Updated book
     *
     */
    @PutMapping
    private ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO dto){
        BookDTO bookDTO=bookService.createOrUpdateBook(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDTO);
    }
}
