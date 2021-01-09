package fide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "league_player")
public class LeaguePlayer extends BaseEntity {
	@Column(name = "league_id", nullable = false)
	private Integer leagueId;

	@Column(name = "player_id", nullable = false)
	private Integer playerId;

	@Column(name = "total_point")
	private Double totalPoint;

	public Integer getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Double getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Double totalPoint) {
		this.totalPoint = totalPoint;
	}
}
