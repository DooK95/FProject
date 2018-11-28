package pl.coderslab.service;

import pl.coderslab.model.TrainingDay;

import java.util.List;

public interface TrainingsService {

    public void save(TrainingDay trainingDay);

    public void update(TrainingDay trainingDay);

    public TrainingDay findById(long id);

    public void del(long id);

    public List<TrainingDay> findAll();

}
