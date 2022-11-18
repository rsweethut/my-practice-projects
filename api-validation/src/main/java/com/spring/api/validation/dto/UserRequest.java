package com.spring.api.validation.dto;

import com.spring.api.validation.advice.ApplicationExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "Name should not be null")
    private String name;
    @Email(message = "Email ID is Invalid")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "digits only allowed and valid")
    private String mobile;
    private String gender;
    @Min(10)
    @Max(50)
    private int age;
    @NotBlank
    private String nationality;
}
