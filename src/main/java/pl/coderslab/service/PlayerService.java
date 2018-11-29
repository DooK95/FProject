package pl.coderslab.service;

import pl.coderslab.model.Player;

import java.util.List;

public interface PlayerService {

    public void save(Player player);

    public void update(Player player);

    public Player findById(long id);

    public List<Player> findByIdToArray(long id);

    public void del(long id);

    public List<Player> findAll();

    List<Player> findAllActive();
}
