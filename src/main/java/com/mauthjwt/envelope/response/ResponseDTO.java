package com.mauthjwt.envelope.response;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseDTO {
	


	@XmlElement(name="statut")
	private Integer statut;
	
	@XmlElement(name="messages")
	private Map<String, MessagesDTO> messages;
	
	/**
	 * @return
	 */
	public Integer getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 */
	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	/**
	 * Permet d'ajouter un message à la liste des messages de succes
	 * 
	 * @param transactId
	 * @param messageSucces
	 */
	public void addMessageSuccess(String transactId, String messageSucces) {
		
		MessagesDTO messageDTO = new MessagesDTO();
		
		if(this.messages == null) {
			this.messages = new LinkedHashMap<>();
			this.messages.put(transactId, messageDTO);
		} else {
			messageDTO = this.messages.get(transactId);
			if(messageDTO == null) {
				messageDTO = new MessagesDTO();
				this.messages.put(transactId, messageDTO);
			}
		}

		messageDTO.addMessageSuccess(messageSucces);
	}

	/**
	 * Permet d'ajouter une erreur à la liste des erreurs
	 * 
	 * @param transactId
	 * @param erreur
	 */
	public void addError(String transactId, String erreur) {
		
	MessagesDTO messageDTO = new MessagesDTO();
		
		if(this.messages == null) {
			this.messages = new LinkedHashMap<>();
			this.messages.put(transactId, messageDTO);
		} else {
			messageDTO = this.messages.get(transactId);
			if(messageDTO == null) {
				messageDTO = new MessagesDTO();
				this.messages.put(transactId, messageDTO);
			}
		}

		messageDTO.addError(erreur);
	}

	/**
	 * @return the messages
	 */
	public Map<String, MessagesDTO> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(Map<String, MessagesDTO> messages) {
		this.messages = messages;
	}



}
