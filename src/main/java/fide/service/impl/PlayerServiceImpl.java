package fide.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fide.entity.League;
import fide.entity.Player;
import fide.repository.PlayerRepository;
import fide.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public List<Player> getAllPlayerInLeague(League league) {
		return playerRepo.findAll().stream().filter(player -> player.getLeagues().contains(league))
				.collect(Collectors.toList());
	}

	@Override
	public Player getPlayerById(Integer id) {
		return playerRepo.findById(id).get();
	}

	@Override
	public Player saveOrCreatePlayer(Player player) {
		return playerRepo.save(player);
	}

}
