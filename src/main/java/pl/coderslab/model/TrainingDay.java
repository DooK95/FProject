package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TRAININGS")
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WeekDays day;

    @NotNull
    LocalTime startTime;

    @NotNull
    LocalTime endTime;

    @Transient
    String allInfo;

    public Long getId() {
        return id;
    }

    public WeekDays getDay() {
        return day;
    }

    public void setDay(WeekDays day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getAllInfo() {
        return day + ": " + startTime + "-" + endTime;
    }

    @Override
    public String toString() {
        return day + ": " + startTime + "-" + endTime;
    }
}
