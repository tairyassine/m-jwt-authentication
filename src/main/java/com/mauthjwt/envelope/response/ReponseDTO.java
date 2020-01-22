package com.mauthjwt.envelope.response;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mauthjwt.commun.util.liste.ListUtil;

@JsonInclude(JsonInclude.Include.NON_NULL) 
@JsonPropertyOrder({ ReponseDTO.STATUS_FIELD, ReponseDTO.ERRORS_FIELD, ReponseDTO.SUCCESS_FIELD })
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ReponseDTO {
	
	static final String STATUS_FIELD = "status";
	static final String ERRORS_FIELD = "error";
	static final String SUCCESS_FIELD = "success";
	

	@XmlElement(name=STATUS_FIELD)
	private Integer status;
	
	@XmlElement(name=ERRORS_FIELD)
	private List<MessageDTO> errors;
	
	@XmlElement(name=SUCCESS_FIELD)
	private List<MessageDTO> success;
	
	public ReponseDTO() {
		this.errors = new ArrayList<>();
		this.success = new ArrayList<>();
	}
	
	/**
	 * @param reponse
	 */
	public ReponseDTO(ReponseDTO reponse) {
		this.status = reponse.getStatus();
		this.errors = reponse.getErrors();
		this.success = reponse.getSuccess();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer statut) {
		this.status = statut;
	}

	public List<MessageDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<MessageDTO> errors) {
		this.errors = errors;
	}

	public List<MessageDTO> getSuccess() {
		return success;
	}

	public void setSuccess(List<MessageDTO> success) {
		this.success = success;
	}
	
	/**
	 * Permet d'ajouter une collection à la liste des erreurs de la réponse de l'objet appelant
	 * 
	 * @param errorsToAdd
	 */
	public void addErrors(List<MessageDTO> errorsToAdd) {
		if(ListUtil.isEmpty(errorsToAdd)) {
			return;
		}
		
		if(this.errors == null) {
			this.errors = errorsToAdd;
			return;
		}
		
		this.errors.addAll(errorsToAdd);
	}
	
	/**
	 * Permet d'ajouter une collection à la liste des erreurs de la réponse de l'objet appelant
	 * 
	 * @param errorToAdd
	 */
	public void addError(MessageDTO errorToAdd) {
		if(errorToAdd == null) {
			return;
		}
		
		if(this.errors == null) {
			this.errors = new LinkedList<>();
			return;
		}
		
		this.errors.add(errorToAdd);
	}
	
	/**
	 * Ajout d'une liste de success à la liste de success de lo'objet courant
	 * 
	 * @param successToAdd
	 */
	public void addSuccess(List<MessageDTO> successToAdd) {
		if(ListUtil.isEmpty(successToAdd)) {
			return;
		}
		
		if(this.success == null) {
			this.success = successToAdd;
			return;
		}
		
		this.success.addAll(successToAdd);
	}
	
	/**
	 * Ajout d'un success à la liste de success de l'objet courant
	 * 
	 * @param id
	 * @param message
	 */
	public void addSuccess(String id, String message) {
		
		MessageDTO successToAdd = new MessageDTO();
		
		successToAdd.setId(id);
		successToAdd.setMessage(message);
		
		if(this.success == null) {
			this.success = new LinkedList<>();
		}
		
		this.success.add(successToAdd);
	}
}
