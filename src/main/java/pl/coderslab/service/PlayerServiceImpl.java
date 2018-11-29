package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Player;
import pl.coderslab.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService  {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void update(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player findById(long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findByIdToArray(long id) {
        List<Player> list = new ArrayList<>();
        list.add(playerRepository.findById(id));
        return list;
    }

    @Override
    public void del(long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findAllActive() {
        return playerRepository.findAllByStatusEquals("ACTIVE");
    }
}
