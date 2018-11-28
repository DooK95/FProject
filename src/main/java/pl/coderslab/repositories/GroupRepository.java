package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Group;


public interface GroupRepository extends JpaRepository <Group, Long> {
    Group findGroupByAddressContaining(String street);
    Group findGroupById(long id);
}
