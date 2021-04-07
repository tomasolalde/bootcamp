package products.challenge.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String code;
	private final String description;
	private final Integer statusCode;

	public ApiException(String code, String description, Integer statusCode) {
		super(description);
		this.code = code;
		this.description = description;
		this.statusCode = statusCode;
	}

	public ApiException(HttpStatus httpStatus, String description) {
		super(description);
		this.code = httpStatus.name();
		this.description = description;
		this.statusCode = httpStatus.value();
	}

	public ApiException(String code, String description, Integer statusCode, Throwable cause) {
		super(description, cause);
		this.code = code;
		this.description = description;
		this.statusCode = statusCode;
	}


	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public Integer getStatusCode() {
		return this.statusCode;
	}
}
