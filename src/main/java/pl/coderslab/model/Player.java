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

    @Enumerated(EnumType.STRING)
    @Column(length = 3)
    private WeekTrainings numberOfTrainings;

    @Enumerated(EnumType.STRING)
    private PlayerStatus status;

    @ManyToOne
    private Group group;

}
