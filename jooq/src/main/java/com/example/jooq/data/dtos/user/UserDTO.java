package com.example.jooq.data.dtos.user;


import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO  implements Serializable {
    private String name;
    @Email(message = "Emai is not valid")
    private String email;
    private String phone;
    private String address;
}
