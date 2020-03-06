package com.mauthjwt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn ;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROFIL")
public class Profil implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String codeTypeUser;
	
	@Column 
	private String libelle;
	
	@ManyToMany(cascade= {CascadeType.DETACH})
    @JoinTable(name = "PRO_ROL",
    joinColumns = @JoinColumn(name = "pro_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Role> roles;
	
	public Profil(){}
	
	public Profil(String codeTypeUser,String libelle ){
		this.codeTypeUser=codeTypeUser;
		this.libelle= libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeTypeUser() {
		return codeTypeUser;
	}

	public void setCodeTypeUser(String codeTypeUser) {
		this.codeTypeUser = codeTypeUser;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
