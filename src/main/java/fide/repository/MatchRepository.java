package fide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fide.entity.Match;
import fide.entity.Player;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
	Match findByFirstPlayerAndSecondPlayer(Player firstPlayer, Player secondPlayer);
}
