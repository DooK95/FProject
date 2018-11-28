package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    private List<TrainingDay> trainingDay;

    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    @ManyToMany(mappedBy = "groups")
    private List<Coach> coaches;

    @OneToMany
    private List<Player> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<TrainingDay> getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(List<TrainingDay> trainingDay) {
        this.trainingDay = trainingDay;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public void setStatus(GroupStatus status) {
        this.status = status;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    @Override
    public String toString() {
        return address + ", " + trainingDay + ", " + status;
    }
}