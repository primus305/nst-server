package nst.projekat.dto;

import lombok.Data;

@Data
public class SpeakerDTO {
    private Long speakerID;
    private String firstName;
    private String lastName;
    private String faculty;
    private String organization;
    private String username;
    private String password;
    private String email;
}
