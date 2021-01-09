package fide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fide.entity.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

}
