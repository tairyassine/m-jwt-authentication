package com.mauthjwt.envelope.response;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ MessageDTO.MESSAGE_FIELD, MessageDTO.ERRORS_DETAILS_FIELD, MessageDTO.ID_FIELD, MessageDTO.NAME_FIELD })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class MessageDTO {

	static final String ID_FIELD = "id";
	static final String NAME_FIELD = "name";
	static final String MESSAGE_FIELD = "message";
	static final String ERRORS_DETAILS_FIELD = "error_details";
	
	@XmlElement(name=ID_FIELD)
	private String id;
	
	@XmlElement(name=NAME_FIELD)
	private String name;
	
	@XmlElement(name=MESSAGE_FIELD)
	private String message;
	
	@XmlElement(name=ERRORS_DETAILS_FIELD)
	private List<ErrorDetailDTO> errorsDetails;

	
	public MessageDTO() {}
	
	public MessageDTO(String name, String message, List<ErrorDetailDTO> errorsDetails) {
		this(message, errorsDetails);
		this.name = name;
	}
	
	public MessageDTO(String message, List<ErrorDetailDTO> errorsDetails, String id) {
		this(message, errorsDetails);
		this.id = id;
	}
	
	public MessageDTO(String message, List<ErrorDetailDTO> errorsDetails) {
		this.errorsDetails = errorsDetails;
		this.message = message;
	}
	
	public MessageDTO(String message) {
		this.message = message;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ErrorDetailDTO> getErrorsDetails() {
		return errorsDetails;
	}

	public void setErrorsDetails(List<ErrorDetailDTO> errorsDetails) {
		this.errorsDetails = errorsDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageDTO other = (MessageDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/**
	 * Permet d'ajouter une erreur à la liste des erreurs
	 * 
	 * @param errorCode
	 * @param errorDescription
	 */
	public void addErrorDetail(String errorCode, String errorDescription) {
		if(this.errorsDetails == null) {
			this.errorsDetails = new LinkedList<>();
		}
		this.errorsDetails.add(new ErrorDetailDTO(errorCode, errorDescription));
	}

	
	@Override
	public String toString() {
		return "[name:"+this.name+"][id:"+this.id+"]";
	}
	
}
