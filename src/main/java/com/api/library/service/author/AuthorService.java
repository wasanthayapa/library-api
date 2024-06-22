package com.api.library.service.author;

import com.api.library.dto.author.AuthorDTO;

import java.util.List;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public interface AuthorService {

    List<AuthorDTO> getAll();

    AuthorDTO findAuthorById(Integer id);

    AuthorDTO createAuthor(AuthorDTO dto);

    AuthorDTO updateAuthor(Integer authorId,AuthorDTO dto);
}
