package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Coach;
import pl.coderslab.repositories.CoachRepoistory;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    CoachRepoistory coachRepoistory;


    @Override
    public void save(Coach coach) {
        coachRepoistory.save(coach);
    }

    @Override
    public void update(Coach coach) {
        coachRepoistory.save(coach);
    }

    @Override
    public Coach findById(long id) {
        return coachRepoistory.findById(id);
    }

    @Override
    public Coach findByName(String name) {
        return coachRepoistory.findByLastName(name);
    }

    @Override
    public void del(long id) {
        coachRepoistory.delete(coachRepoistory.findById(id));
    }

    @Override
    public List<Coach> findByIdToArray(long id) {
        List<Coach> list = new ArrayList<>();
        list.add(coachRepoistory.findById(id));
        return list;
    }

    @Override
    public List<Coach> findAll() {

        return coachRepoistory.findAll();
    }
}
