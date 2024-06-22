package com.api.library.controller.author;

import com.api.library.dto.author.AuthorDTO;
import com.api.library.service.author.AuthorService;
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
@RequestMapping("/author")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorController {

    private final AuthorService authorService;

    /***
     *
     * @return List of author register in system
     */
    @GetMapping
    private ResponseEntity<List<AuthorDTO>> getAllAuthor(){
        List<AuthorDTO> list=authorService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    /**
     *
     * @param id registered author id
     * @return Details of Registered Author
     *
     */
    @GetMapping("/{id}")
    private ResponseEntity<AuthorDTO> getAuthorById(@PathVariable("id")Integer id){
        AuthorDTO dto=authorService.findAuthorById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dto);
    }

    /**
     *
     * @param dto required data for Author registration
     * @return Registered author
     *
     */

    @PostMapping
    private ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO dto){
        AuthorDTO authorDTO=authorService.createAuthor(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorDTO);
    }

    /**
     *
     * @param dto updated data for Author
     * @return Updated author
     *
     */
    @PutMapping("/{id}")
    private ResponseEntity<AuthorDTO> updateAuthor(@PathVariable("id")Integer authorId,@RequestBody AuthorDTO dto){
        AuthorDTO authorDTO=authorService.updateAuthor(authorId,dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorDTO);
    }
}
