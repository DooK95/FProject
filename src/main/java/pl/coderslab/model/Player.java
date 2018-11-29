package pl.coderslab.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "PLAYERS")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @NotBlank
    private String phoneNumber;

    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]")
    private String birthYear;

    @NotBlank
    private String address;

    @NotBlank
    private String code_address;

    @NotBlank
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private WeekTrainings numberOfTrainings;

    @Enumerated(EnumType.STRING)
    private PlayerStatus status;

    @ManyToOne
    private Group group;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode_address() {
        return code_address;
    }

    public void setCode_address(String code_address) {
        this.code_address = code_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeekTrainings getNumberOfTrainings() {
        return numberOfTrainings;
    }

    public void setNumberOfTrainings(WeekTrainings numberOfTrainings) {
        this.numberOfTrainings = numberOfTrainings;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
