package com.api.library.mapper.book;

import com.api.library.dto.author.AuthorDTO;
import com.api.library.dto.book.BookDTO;
import com.api.library.entity.author.Author;
import com.api.library.entity.book.Book;
import com.api.library.mapper.GenericMapper;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public class BookMapper extends GenericMapper<BookDTO, Book> {

    /***
     *  Create Single Object of Book Mapper
     */
    private static BookMapper instance=null;
    public static BookMapper getInstance(){
        if(instance==null){
            instance=new BookMapper();
        }
        return instance;
    }

    /**
     * Transfer Book Object to BookDTO Object
     * @param model  {@link Book}
     * @param dto {@link BookDTO}
     *
     */
    @Override
    public void dtoToModel(Book model, BookDTO dto) {
        model.setId(dto.getId());
        model.setVersion(dto.getVersion());
        model.setName(dto.getName());
        model.setIsbn(dto.getIsbn());
    }

    /***
     *
     * @param model {@link Book}
     * @return BookDTO
     */
    @Override
    public BookDTO modelTODTO(Book model) {
        BookDTO dto=new BookDTO();
        dto.setId(model.getId());
        dto.setVersion(model.getVersion());
        dto.setName(model.getName());
        dto.setIsbn(model.getIsbn());
        setAuthor(dto,model);
        return dto;
    }

    /**
     *
     * Set {@link BookDTO} to Author added
     * @param dto {@link BookDTO}
     * @param book {@link Book}
     *
     */
    private void setAuthor(BookDTO dto,Book book){
        if(book.getAuthor()!=null){
            dto.setAuthorId(book.getAuthor().getId());
            dto.setAuthorName(book.getAuthor().getFirstName()+" "+book.getAuthor().getLastName());
        }
    }
}
