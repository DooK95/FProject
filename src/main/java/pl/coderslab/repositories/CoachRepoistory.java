package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Coach;

public interface CoachRepoistory extends JpaRepository<Coach, Long > {
    Coach findByLastName(String name);
    Coach findById(long id);
}
