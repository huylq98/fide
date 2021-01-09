package fide.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "player")
@JsonIgnoreProperties({"leagues"})
public class Player extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "elorating", nullable = false)
	private Double eloRating;

	@Column(name = "note")
	private String note;

	@ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
	private List<League> leagues = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Double getEloRating() {
		return eloRating;
	}

	public void setEloRating(Double eloRating) {
		this.eloRating = eloRating;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}
}
