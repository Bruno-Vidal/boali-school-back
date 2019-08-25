package br.com.boali.graphschool.config.handler;


import br.com.boali.graphschool.business.exception.BaseNotFoundException;
import br.com.boali.graphschool.resource.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler{

	@ExceptionHandler({ BaseNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorDTO> handleNotFound(BaseNotFoundException ex,
												   WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
									.body(ErrorDTO.builder()
													.message(ex.getMessage())
													.status(HttpStatus.NOT_FOUND.value())
													.timestamp(new Date())
											      .build());
	}
}
