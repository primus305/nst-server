package nst.projekat.dto;

import lombok.Data;
import nst.projekat.domain.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    private Long userID;
    private String firstName;
    private String lastName;
    private String faculty;
    private String organization;
    private String username;
    private String password;
    private Role role;
    private String email;
}
