package com.api.library.mapper;

import com.api.library.dto.BaseDTO;
import com.api.library.entity.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Project library-api
 * Created by Vasantha Yapa on 06/21/2024
 **/

public abstract class GenericMapper<DTO extends BaseDTO, MODEL extends BaseModel> {

    /***
     * Generic implementation for DTO to Model
     * @param model {@link BaseModel}
     * @param dto {@link BaseDTO}
     *
     */
    public abstract void dtoToModel(MODEL model, DTO dto);

    /**
     * Generic implementation for Model to DTO
     *
     * @param model {@link BaseModel}
     * @return DTO {@link BaseDTO}
     */
    public abstract DTO modelTODTO(MODEL model);

    /***
     * Common implementation for Model List to to DTO Lisy
     * @param modelList {@link List} of {@link BaseModel}
     * @return java.util.List of {@link BaseDTO}
     *
     */
    public List<DTO> dtoToModelCollection(List<MODEL> modelList) {
        List<DTO> dtoList = new ArrayList<>();
        for (MODEL model : modelList) {
            dtoList.add(modelTODTO(model));
        }
        return dtoList;
    }

}
