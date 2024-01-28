package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private Double price;
    private String address;

    @ManyToOne//(fetch = FetchType.LAZY)
    //Lazy = it will not fetch the other user_id data while its fetching the property data (default EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    UserEntity userEntity = new UserEntity();


}
