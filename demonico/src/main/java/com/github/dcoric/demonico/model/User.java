package com.github.dcoric.demonico.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "FIRST_NAME", nullable = true)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;
	
	@Column(name = "birth_date", nullable = true)
	private Date birthDate;
	
	@Column(name = "insertion_date", nullable = false)
	private Date insertionDate;
	
	@Transient
	private Long age;
	
	public Long getAge() {
		Date today = new Date();
		return (birthDate!=null?today.getTime() - birthDate.getTime() : null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

}
