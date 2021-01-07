package fide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "match")
public class Match extends BaseEntity {
	@Column(name = "round")
	private String round;

	@Column(name = "firstplayer")
	private Integer firstPlayer;

	@Column(name = "secondplayer")
	private Integer secondPlayer;

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public Integer getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Integer firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public Integer getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Integer secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
}
