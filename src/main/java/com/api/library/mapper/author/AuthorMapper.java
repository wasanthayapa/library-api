package com.api.library.mapper.author;

import com.api.library.dto.author.AuthorDTO;
import com.api.library.entity.author.Author;
import com.api.library.mapper.GenericMapper;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public class AuthorMapper extends GenericMapper<AuthorDTO, Author> {

    /***
     *  Create Single Object of Author Mapper
     */
    private static AuthorMapper instance=null;
    public static AuthorMapper getInstance(){
        if(instance==null){
            instance=new AuthorMapper();
        }
        return instance;
    }

    /**
     * Transfer Author Object to AuthorDTO Object
     * @param model  {@link Author}
     * @param dto {@link AuthorDTO}
     *
     */
    @Override
    public void dtoToModel(Author model, AuthorDTO dto) {
        model.setId(dto.getId());
        model.setVersion(dto.getVersion());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
    }

    /***
     *
     * @param model {@link Author}
     * @return AuthorDTO
     */
    @Override
    public AuthorDTO modelTODTO(Author model) {
        AuthorDTO dto=new AuthorDTO();
        dto.setId(model.getId());
        dto.setVersion(model.getVersion());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        return dto;
    }
}
