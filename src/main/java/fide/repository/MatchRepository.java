package fide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fide.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
}