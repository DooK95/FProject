package pl.coderslab.service;

import pl.coderslab.model.Group;

import java.util.List;

public interface GroupService {
    public void save (Group coach);
    public void update (Group coach);
    public Group findByStreet (String street);
    public void del (long id);
    public List<Group> findAll();
    public Group findById(Long id);

    List<Group> findByIdToArray(long id);
}
