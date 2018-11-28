package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Group;
import pl.coderslab.repositories.GroupRepository;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void save(Group coach) {
        groupRepository.save(coach);
    }

    @Override
    public void update(Group coach) {
        groupRepository.save(coach);
    }

    @Override
    public Group findByStreet(String street) {
        return groupRepository.findGroupByAddressContaining(street);
    }

    @Override
    public void del(long id) {
        groupRepository.delete(groupRepository.findGroupById(id));
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findGroupById(id);
    }
}
