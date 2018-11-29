package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findById(long id);
}
