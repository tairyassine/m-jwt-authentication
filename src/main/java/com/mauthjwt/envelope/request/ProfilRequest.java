package com.mauthjwt.envelope.request;

import java.io.Serializable;

public class ProfilRequest implements Serializable {
	
	private static final long serialVersionUID = 8052382398032049762L;
	
	private String libelle;
	private String codeTypeUser;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCodeTypeUser() {
		return codeTypeUser;
	}
	public void setCodeTypeUser(String codeTypeUser) {
		this.codeTypeUser = codeTypeUser;
	}
}
