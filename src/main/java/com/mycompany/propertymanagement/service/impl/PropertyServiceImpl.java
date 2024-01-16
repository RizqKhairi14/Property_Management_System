package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.Converter.PropertyConverter;
import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyRepository propRepo;

    @Autowired
    private PropertyConverter convert;

    @Override
    public PropertyDTO saveProperty(PropertyDTO newProp) {

        PropertyEntity pe = convert.convertDTOtoEntity(newProp);
        pe = propRepo.save(pe);

        PropertyDTO DTO = convert.convertEntitytoDTO(pe);
        return DTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        System.out.println("This is from inside service " + dummy);
        System.out.println("This is from inside service " + dbUrl);

        List<PropertyEntity> listofProperties = (List<PropertyEntity>) propRepo.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        for (PropertyEntity pe : listofProperties){
            PropertyDTO DTO = convert.convertEntitytoDTO(pe);
            propList.add(DTO);
        }

        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO updateProperty, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setTitle(updateProperty.getTitle());
            pe.setOwnerEmail(updateProperty.getOwnerEmail());
            pe.setPrice(updateProperty.getPrice());
            pe.setDescription(updateProperty.getDescription());
            pe.setOwnerName(updateProperty.getOwnerName());
            pe.setAddress(updateProperty.getAddress());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }

        return DTO;
    }

    @Override
    public PropertyDTO updatePropTitle(PropertyDTO updatePropTitle, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if (optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setTitle(updatePropTitle.getTitle());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }

        return DTO;
    }

    @Override
    public PropertyDTO updatePropDesc(PropertyDTO updatePropDesc, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if (optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setDescription(updatePropDesc.getDescription());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }

        return DTO;
    }

    @Override
    public PropertyDTO updatePropOwnerName(PropertyDTO updatePropOwnerName, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if (optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setOwnerName(updatePropOwnerName.getOwnerName());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }
        return DTO;
    }

    @Override
    public PropertyDTO updatePropOwnerEmail(PropertyDTO updatePropOwnerEmail, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if (optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setOwnerEmail(updatePropOwnerEmail.getOwnerEmail());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }
        return DTO;
    }

    @Override
    public PropertyDTO updatePropPrice(PropertyDTO updatePropPrice, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if (optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setPrice(updatePropPrice.getPrice());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }
        return DTO;
    }

    @Override
    public PropertyDTO updatePropAddress(PropertyDTO updatePropAddress, Long propertyId) {

        Optional<PropertyEntity> optEn = propRepo.findById(propertyId);
        PropertyDTO DTO = null;
        if (optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setAddress(updatePropAddress.getAddress());

            DTO = convert.convertEntitytoDTO(pe);
            propRepo.save(pe);
        }
        return DTO;
    }

    @Override
    public void deleteProperty(Long propertyID) {
        propRepo.deleteById(propertyID);
    }
}
