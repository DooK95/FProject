package pl.coderslab.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.service.PlayerService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String address;

    @NotNull
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TrainingDay> trainingDay;

    @NotNull
    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    @ManyToMany(mappedBy = "groups")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Coach> coaches;

    @OneToMany(mappedBy = "group")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Player> players;

    @Transient
    String allInfo;

    @Transient
    String groupSize;

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

    public String getAllInfo() {
        return address + ", " + trainingDay + ", " + status;
    }

//    public String getGroupSize() {
//        return String.valueOf(players.size());
//    }
    public String getGroupSize() {
        int quantity = 0;
        for (Player p : players) {
            if(p.getStatus() == PlayerStatus.ACTIVE){
                quantity++;
            }
        }
        return String.valueOf(quantity);
    }

    @Override
    public String toString() {
        return address + ", " + trainingDay + ", " + status;
    }
}