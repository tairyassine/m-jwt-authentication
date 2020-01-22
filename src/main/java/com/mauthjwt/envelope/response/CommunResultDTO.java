package com.mauthjwt.envelope.response;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.mauthjwt.web.dto.commun.ResultSet;

@JsonInclude(JsonInclude.Include.NON_NULL) 
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CommunResultDTO {
	
	@JsonUnwrapped
	private ReponseDTO response;
	
	@JsonUnwrapped
	private ResultSet resultSet;


	public CommunResultDTO(ReponseDTO response,ResultSet resultSet) {
		
		this.response = response;
		this.resultSet = resultSet;
	}

	
	/**
	 * Default Constructor
	 */
	public CommunResultDTO() {
		super();
	}


	public ReponseDTO getResponse() {
		return response;
	}


	public void setResponse(ReponseDTO response) {
		this.response = response;
	}


	public ResultSet getResultSet() {
		return resultSet;
	}


	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}



	
}
