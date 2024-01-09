package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyService PropertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty (@RequestBody PropertyDTO newProp){

        newProp = PropertyService.saveProperty(newProp);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(newProp, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){

        System.out.println(dummy);
        System.out.println(dbUrl);

        List<PropertyDTO> propertyList = PropertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO updateProp, @PathVariable Long propertyId){

        updateProp = PropertyService.updateProperty(updateProp, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updateProp, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-title/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropTitle(@RequestBody PropertyDTO updatePropTitle, @PathVariable Long propertyId){

        updatePropTitle = PropertyService.updatePropTitle(updatePropTitle, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatePropTitle, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-desc/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropDesc(@RequestBody PropertyDTO updatePropDesc, @PathVariable Long propertyId){

        updatePropDesc = PropertyService.updatePropDesc(updatePropDesc, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatePropDesc, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-owner-name/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropOwnerName(@RequestBody PropertyDTO updatePropOwnerName, @PathVariable Long propertyId){

        updatePropOwnerName = PropertyService.updatePropOwnerName(updatePropOwnerName, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatePropOwnerName, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-owner-email/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropOwnerEmail(@RequestBody PropertyDTO updatePropOwnerEmail, @PathVariable Long propertyId){

        updatePropOwnerEmail = PropertyService.updatePropOwnerEmail(updatePropOwnerEmail, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatePropOwnerEmail, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-prop-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropPrice(@RequestBody PropertyDTO updatePropPrice, @PathVariable Long propertyId){

        updatePropPrice = PropertyService.updatePropPrice(updatePropPrice, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatePropPrice, HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-prop-address/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropAddress(@RequestBody PropertyDTO updatePropAddress, @PathVariable Long propertyId){

        updatePropAddress = PropertyService.updatePropAddress(updatePropAddress, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(updatePropAddress, HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){

        PropertyService.deleteProperty(propertyId);
        ResponseEntity responseEntity = new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
