package kuntakyol.aysegul.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Criteria {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String criteriaName;
private Date startDate;
private Date finishDate;
private String unit;
private long totalAmount;

@ManyToMany(mappedBy="criterias")
private Set<User> users;

public Criteria() {
	super();
}
public Criteria(String criteriaName, Date startDate, Date finishDate, String unit, long totalAmount) {
	super();
	this.criteriaName = criteriaName;
	this.startDate = startDate;
	this.finishDate = finishDate;
	this.unit = unit;
	this.totalAmount = totalAmount;
}

public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}
public String getCriteriaName() {
	return criteriaName;
}
public void setCriteriaName(String criteriaName) {
	this.criteriaName = criteriaName;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getFinishDate() {
	return finishDate;
}
public void setFinishDate(Date finishDate) {
	this.finishDate = finishDate;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public long getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(long totalAmount) {
	this.totalAmount = totalAmount;
}



}
