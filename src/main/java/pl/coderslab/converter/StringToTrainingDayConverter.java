package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.TrainingDay;
import pl.coderslab.service.TrainingsService;

import java.util.ArrayList;
import java.util.List;

public class StringToTrainingDayConverter implements Converter<String, List<TrainingDay>> {

    @Autowired
    TrainingsService trainingsService;

    @Override
    public List<TrainingDay> convert(String s) {
        List<TrainingDay> trainingDayArrayList = new ArrayList<>();
        Long id = Long.parseLong(s);
        TrainingDay trainingDay = trainingsService.findById(id);
        trainingDayArrayList.add(trainingDay);
        return trainingDayArrayList;
    }
}
