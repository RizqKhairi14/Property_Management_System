package com.mycompany.propertymanagement.Converter;

import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity (PropertyDTO propertyDTO){

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setPrice(propertyDTO.getPrice());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());

        return pe;

    }

    public PropertyDTO convertEntitytoDTO (PropertyEntity propertyEntity){

        PropertyDTO DTO = new PropertyDTO();
        DTO.setId(propertyEntity.getId());
        DTO.setTitle(propertyEntity.getTitle());
        DTO.setPrice(propertyEntity.getPrice());
        DTO.setDescription(propertyEntity.getDescription());
        DTO.setAddress(propertyEntity.getAddress());
        DTO.setUserId(propertyEntity.getUserEntity().getId());

        return DTO;
    }

}
