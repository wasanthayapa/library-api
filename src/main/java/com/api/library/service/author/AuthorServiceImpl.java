package com.api.library.service.author;

import com.api.library.dto.author.AuthorDTO;
import com.api.library.entity.author.Author;
import com.api.library.exception.AuthorException;
import com.api.library.exception.RecodeNotFoundException;
import com.api.library.mapper.author.AuthorMapper;
import com.api.library.repository.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    /***
     *
     * Get all Author list
     * @return List of {@link AuthorDTO}
     *
     */
    @Override
    public List<AuthorDTO> getAll() {
        List<Author> authorList = authorRepository.findAll();
        if (authorList.size() > 0) {
            return AuthorMapper.getInstance().dtoToModelCollection(authorList);
        } else {
            throw new RecodeNotFoundException("Cannot find any author");
        }
    }

    /***
     *
     * Get selected author by author id
     * @param id {@link Integer} registered author id
     * @return AuthorDTO Object
     *
     */
    @Override
    public AuthorDTO findAuthorById(Integer id) {
        return AuthorMapper.getInstance().modelTODTO(getAuthorById(id));
    }

    /**
     * Create new Author or Update Existing Author
     *
     * @param dto {@link AuthorDTO}
     * @return Created or Updated Author {@link AuthorDTO}
     */
    @Override
    @Transactional
    public AuthorDTO createOrUpdateAuthor(AuthorDTO dto) {
        try {
            Author author = createOrUpdate(dto);
            AuthorMapper.getInstance().dtoToModel(author, dto);
            return AuthorMapper.getInstance().modelTODTO(authorRepository.save(author));
        }catch (AuthorException exception){
            throw new AuthorException("Error occurred Author creation");
        }
    }

    /***
     *
     * find existing author object or create author object
     * @param dto {@link AuthorDTO}
     * @return Author object {@link Author}
     *
     */
    private Author createOrUpdate(AuthorDTO dto) {
        if (dto.getId() != null) {
            return getAuthorById(dto.getId());
        }
        return new Author();
    }

    /***
     *
     * Find Author by id
     * @param id selected author id {@link Integer}
     * @return Author according to selected author id
     *
     */
    private Author getAuthorById(Integer id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            throw new RecodeNotFoundException("Can not find Author for selected id");
        }
    }
}
