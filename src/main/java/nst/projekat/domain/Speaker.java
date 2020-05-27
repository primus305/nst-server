package nst.projekat.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@Entity
public class Speaker implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speakerID;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String faculty;
    private String organization;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    @Email
    private String email;

    public Speaker() {
    }

    public Speaker(String firstName, String lastName, String faculty, String organization, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.organization = organization;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getSpeakerID() {
        return speakerID;
    }

    public void setSpeakerID(Long speakerID) {
        this.speakerID = speakerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "speakerID=" + speakerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", organization='" + organization + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("SPEAKER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
