package com.mauthjwt.envelope.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ ErrorDetailDTO.ERROR_CODE_FIELD, ErrorDetailDTO.ERROR_DESCRIPTION_FIELD })
@JsonInclude(Include.NON_NULL)
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorDetailDTO implements Serializable {

	private static final long serialVersionUID = -717614682352269456L;
	
	public static final String ERROR_CODE_FIELD = "error_code";
	public static final String ERROR_DESCRIPTION_FIELD = "error_description";
	
	@XmlElement(name=ERROR_CODE_FIELD)
	private String errorCode;
	
	@XmlElement(name=ERROR_DESCRIPTION_FIELD)
	private String errorDescription;

	public ErrorDetailDTO(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
