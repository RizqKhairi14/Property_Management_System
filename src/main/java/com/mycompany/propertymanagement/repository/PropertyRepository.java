package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends CrudRepository <PropertyEntity, Long> {

    // uses query to get the data
    //@Query("SELECT p FROM PropertyEntity p WHERE p.UserEntity.id = :userId AND p.title = :title")
    // -> use the AND annotation if you want to get more field and also implement it below
    //List<PropertyEntity> findAllByUserEntityId (@Param("userId") Long userId, @Param("title") String title);

    List<PropertyEntity> findAllByUserEntityId (Long userId);

}
