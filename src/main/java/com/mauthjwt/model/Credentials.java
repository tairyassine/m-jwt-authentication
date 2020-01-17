package com.mauthjwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_COMPLEMENT")
public class Credentials implements Serializable {
	
	@Id
	@Column(nullable=true)
	private Long id;
	
	@Column
	private String password;
	
	@Column
	private String alias;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private UserDb user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public UserDb getUser() {
		return user;
	}

	public void setUser(UserDb user) {
		this.user = user;
	}

}
