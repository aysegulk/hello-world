package kuntakyol.aysegul.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;
	private String password;
	private String name;
	private String surname;
	
	
@ManyToOne
private Role role;
	
@ManyToOne
private Manager manager;

@ManyToMany
private Set<Criteria> criterias;



public User() {
	super();
}


public User(String email, String password, String name, String surname, Role role, Manager manager,
		Set<Criteria> criterias) {
	super();
	this.email = email;
	this.password = password;
	this.name = name;
	this.surname = surname;
	this.role = role;
	this.manager = manager;
	this.criterias = criterias;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}



public Manager getManager() {
	return manager;
}


public void setManager(Manager manager) {
	this.manager = manager;
}


public Set<Criteria> getCriterias() {
	return criterias;
}

public void setCriterias(Set<Criteria> criterias) {
	this.criterias = criterias;
}


}
