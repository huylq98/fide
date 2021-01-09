package fide.service;

import java.util.List;

import fide.entity.League;
import fide.entity.Player;

public interface PlayerService {
	List<Player> getAllPlayerInLeague(League league);

	Player getPlayerById(Integer id);
	
	Player saveOrCreatePlayer(Player player);
}
