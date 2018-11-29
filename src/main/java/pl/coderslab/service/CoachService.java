package pl.coderslab.service;

import pl.coderslab.model.Coach;

import java.util.List;

public interface CoachService {
    public void save (Coach coach);
    public void update (Coach coach);
    public Coach findById (long id);
    public Coach findByName(String name);
    public void del (long id);

    List<Coach> findByIdToArray(long id);

    public List<Coach> findAll();
}
