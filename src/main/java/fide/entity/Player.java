package fide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "dob")
	private Integer dob;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "elorating", nullable = false)
	private Float eloRating;

	@Column(name = "note")
	private String note;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDob() {
		return dob;
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Float getEloRating() {
		return eloRating;
	}

	public void setEloRating(Float eloRating) {
		this.eloRating = eloRating;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
