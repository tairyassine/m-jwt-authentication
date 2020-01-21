package com.mauthjwt.envelope.response;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class MessagesDTO {
	
	@XmlElement(name="messages")
	private List<String> success;
	
	@XmlElement(name="erreurs")
	private List<String> errors;
	
	public MessagesDTO() {
	}

	/**
	 * Permet d'ajouter un message à la liste des messages de succes
	 * @param message
	 */
	public void addMessageSuccess(String message) {
		if(this.success == null) {
			this.success = new LinkedList<>();
		}
		this.success.add(message);
	}

	/**
	 * Permet d'ajouter une erreur à la liste des erreurs
	 * @param erreur
	 */
	public void addError(String erreur) {
		if(this.errors == null) {
			this.errors = new LinkedList<>();
		}
		this.errors.add(erreur);
	}

	/**
	 * @return the success
	 */
	public List<String> getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(List<String> success) {
		this.success = success;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
