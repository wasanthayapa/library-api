package com.api.library.service.book;

import com.api.library.dto.book.BookDTO;
import com.api.library.entity.book.Book;
import com.api.library.exception.AuthorException;
import com.api.library.exception.BookException;
import com.api.library.exception.RecodeNotFoundException;
import com.api.library.mapper.book.BookMapper;
import com.api.library.repository.author.AuthorRepository;
import com.api.library.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    /***
     *
     * Get all Book list
     * @return List of {@link BookDTO}
     *
     */
    @Override
    public List<BookDTO> getAll() {
        List<Book> bookList = bookRepository.findAll();
        if (bookList.size() > 0) {
            return BookMapper.getInstance().dtoToModelCollection(bookList);
        } else {
            throw new RecodeNotFoundException("Cannot find any Book");
        }
    }

    /***
     *
     * Get all Book Paginating list
     * @return Page of {@link BookDTO}
     *
     */
    @Override
    public Page<BookDTO> getAll(Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        Page<Book> bookPage = bookRepository.findAll(pageable);
        if (bookPage.getTotalElements() > 0) {
            return BookMapper.getInstance().dtoToModelPage(bookPage);
        } else {
            throw new RecodeNotFoundException("Cannot find any Books");
        }
    }

    /***
     *
     * Get selected book by book id
     * @param id {@link Integer} registered book id
     * @return BookDTO Object
     *
     */
    @Override
    public BookDTO findBookById(Integer id) {
        return BookMapper.getInstance().modelTODTO(getBookById(id));
    }

    /**
     * Create new Book
     *
     * @param dto {@link BookDTO}
     * @return Created  Book {@link BookDTO}
     */
    @Override
    @Transactional
    public BookDTO createBook(BookDTO dto) {
        try {
            Book book = createOrUpdate(null);
            BookMapper.getInstance().dtoToModel(book, dto);
            setAuthor(book, dto);
            return BookMapper.getInstance().modelTODTO(bookRepository.save(book));
        } catch (BookException exception) {
            throw new AuthorException("Error occurred Book creation");
        }
    }

    /**
     * Update Existing Book
     *
     * @param dto {@link BookDTO}
     * @return Updated  Book {@link BookDTO}
     */

    @Override
    @Transactional
    public BookDTO updateBook(Integer bookId, BookDTO dto) {
        try {
            Book book = createOrUpdate(bookId);
            dto.setId(bookId);
            BookMapper.getInstance().dtoToModel(book, dto);
            setAuthor(book, dto);
            return BookMapper.getInstance().modelTODTO(bookRepository.save(book));
        } catch (BookException exception) {
            throw new AuthorException("Error occurred Book creation");
        }
    }

    /***
     *
     * find existing book object or create book object
     * @param dto {@link BookDTO}
     * @return Book object {@link Book}
     *
     */
    private Book createOrUpdate(Integer bookId) {
        if (bookId != null) {
            return getBookById(bookId);
        }
        return new Book();
    }

    /***
     *
     * Assign Author for Book
     * @param book {@link Book}
     * @param dto {@link BookDTO}
     *
     */
    private void setAuthor(Book book, BookDTO dto) {
        if (dto.getAuthorId() != null) {
            book.setAuthor(authorRepository.getReferenceById(dto.getAuthorId()));
        } else {
            throw new BookException("Please assign Author for Book");
        }
    }

    /***
     *
     * Find Author by id
     * @param id selected book id {@link Integer}
     * @return Book according to selected book id
     *
     */
    private Book getBookById(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new RecodeNotFoundException("Can not find Book for selected id");
        }
    }
}
