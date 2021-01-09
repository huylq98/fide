package fide.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "league")
@JsonIgnoreProperties({"players"})
public class League extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "year")
	private Integer year;

	@Column(name = "heldtimes")
	private Integer heldTimes;

	@Column(name = "location")
	private String location;

	@Column(name = "description")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "league_player", joinColumns = @JoinColumn(name = "league_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
	private List<Player> players = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getHeldTimes() {
		return heldTimes;
	}

	public void setHeldTimes(Integer heldTimes) {
		this.heldTimes = heldTimes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
