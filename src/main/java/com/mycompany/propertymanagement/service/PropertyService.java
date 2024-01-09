package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.DTO.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO newProperty);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO updateProperty, Long propertyId);
    PropertyDTO updatePropTitle(PropertyDTO updatePropTitle, Long propertyId);
    PropertyDTO updatePropDesc(PropertyDTO updatePropDesc, Long propertyId);
    PropertyDTO updatePropOwnerName(PropertyDTO updatePropOwnerName, Long propertyId);
    PropertyDTO updatePropOwnerEmail(PropertyDTO updatePropOwnerEmail, Long propertyId);
    PropertyDTO updatePropPrice(PropertyDTO updatePropPrice, Long propertyId);
    PropertyDTO updatePropAddress(PropertyDTO updatePropAddress, Long propertyId);
    void deleteProperty(Long propertyID);

}
