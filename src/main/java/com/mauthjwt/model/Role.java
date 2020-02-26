package com.mauthjwt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String codeTypeUser;
	
	private String libelle;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Profil> profil;
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	@JoinTable(name="ROL_FON",
	joinColumns=@JoinColumn(name = "rol_id"),
	inverseJoinColumns=@JoinColumn(name = "fon_id"))
	private Set<Fonctionnalite> fonctionnalite;

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

	public Set<Profil> getProfil() {
		return profil;
	}

	public void setProfil(Set<Profil> profil) {
		this.profil = profil;
	}

	public Set<Fonctionnalite> getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(Set<Fonctionnalite> fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

}
