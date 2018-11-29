package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Group;
import pl.coderslab.service.GroupService;

import java.util.ArrayList;

public class StringToGroupConverter implements Converter<String, Group> {

    @Autowired
    GroupService service;

    @Override
    public Group convert(String s) {
        Long id = Long.parseLong(s);
        return service.findById(id);
    }
}
