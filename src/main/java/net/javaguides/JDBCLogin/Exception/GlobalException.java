package net.javaguides.JDBCLogin.Exception;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorApplication> handleLoginException(LoginException la, WebRequest request) {
		ErrorApplication ea = new ErrorApplication(new Date(), la.getMsg(), request.getDescription(false));
		return new ResponseEntity<ErrorApplication>(ea, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorApplication> handleEmptyResultDataAccessException(EmptyResultDataAccessException er,
			WebRequest request) {
		ErrorApplication ea = new ErrorApplication(new Date(), er.getMsg(), request.getDescription(false));
		return new ResponseEntity<ErrorApplication>(ea, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorApplication> handleDataAccessException(DataAccessException er,
			WebRequest request) {
		ErrorApplication ea = new ErrorApplication(new Date(), "ID Invalid", request.getDescription(false));
		return new ResponseEntity<ErrorApplication>(ea, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ValidatorException.class)
	public ResponseEntity<ErrorApplication> handleValidatorException(ValidatorException er,
			WebRequest request) {
		ErrorApplication ea = new ErrorApplication(new Date(), er.getMsg(), request.getDescription(false));
		return new ResponseEntity<ErrorApplication>(ea, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
		ErrorApplication errorDetails = new ErrorApplication(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
