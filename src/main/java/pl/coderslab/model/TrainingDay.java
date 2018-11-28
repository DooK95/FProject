package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TRAININGS")
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    LocalDate day;

    @NotNull
    LocalTime startTime;

    @NotNull
    LocalTime endTime;
}
