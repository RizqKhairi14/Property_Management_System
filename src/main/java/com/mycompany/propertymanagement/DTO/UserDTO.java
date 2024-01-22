package com.mycompany.propertymanagement.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Email must not be empty")
    @NotEmpty(message = "Email must not be empty")
    @Size(min = 5, max = 50, message = "Email must at least consist of 5 to 50 character ")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password must not be empty")
    @NotEmpty(message = "Password must not be empty")
    @Size(min = 7, max = 50, message = "Email must at least consist of 7 character ")
    private String password;

}
