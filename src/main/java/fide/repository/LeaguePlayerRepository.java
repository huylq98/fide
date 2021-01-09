package fide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fide.entity.LeaguePlayer;

@Repository
public interface LeaguePlayerRepository extends JpaRepository<LeaguePlayer, Integer> {
	LeaguePlayer findByPlayerId(Integer playerId);
}
