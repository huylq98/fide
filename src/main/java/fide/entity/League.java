package fide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "league")
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
}
