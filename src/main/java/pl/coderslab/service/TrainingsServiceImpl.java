package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.TrainingDay;
import pl.coderslab.repositories.TrainingRepository;

import java.util.List;

@Service
public class TrainingsServiceImpl implements TrainingsService {

    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public void save(TrainingDay trainingDay) {
        trainingRepository.save(trainingDay);
    }

    @Override
    public void update(TrainingDay trainingDay) {
        trainingRepository.save(trainingDay);
    }

    @Override
    public TrainingDay findById(long id) {
        return trainingRepository.findById(id);
    }

    @Override
    public void del(long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public List<TrainingDay> findAll() {
        return trainingRepository.findAll();
    }

}
