package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.TrainingDay;
import pl.coderslab.service.TrainingsService;

import java.util.ArrayList;
import java.util.List;

public class StringTabToTrainingDayConverter implements Converter<String[], List<TrainingDay>> {
    @Autowired
    TrainingsService service;

    @Override
    public List<TrainingDay> convert(String[] s) {
        List<TrainingDay> trainingDayArrayList = new ArrayList<>();
        for (String str : s) {
            Long id = Long.parseLong(str);
            TrainingDay trainingDay = service.findById(id);
            trainingDayArrayList.add(trainingDay);
        }
        return trainingDayArrayList;
    }
}
