package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.TrainingDay;

public interface TrainingRepository  extends JpaRepository<TrainingDay, Long> {
    TrainingDay findById(long id);
}
