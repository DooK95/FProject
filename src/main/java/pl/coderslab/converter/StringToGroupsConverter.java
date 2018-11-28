package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Group;
import pl.coderslab.service.GroupService;

import java.util.ArrayList;
import java.util.List;

public class StringToGroupsConverter implements Converter<String, List<Group>> {

    @Autowired
    GroupService service;

    @Override
    public List<Group> convert(String s) {
        List<Group> groups = new ArrayList<>();
        Long id = Long.parseLong(s);
        Group group = service.findById(id);
        groups.add(group);
        return groups;
    }
}
