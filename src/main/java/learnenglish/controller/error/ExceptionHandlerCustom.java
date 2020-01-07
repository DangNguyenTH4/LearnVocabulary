package learnenglish.controller.error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import learnenglish.exception.ConfigFailedException;
import learnenglish.exception.SaveWordException;
import learnenglish.exception.WordNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerCustom {
	private Logger logger = LoggerFactory.getLogger(ExceptionHandlerCustom.class);
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeHandler(RuntimeException r){
		logger.info("Runtime Exception handler");
		return new ResponseEntity<>(r.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ConfigFailedException.class)
	public ResponseEntity<String> configFailedHandler(RuntimeException c){
		
		logger.info("Config Failed Exception Handler");
		return new ResponseEntity<String>(c.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(SaveWordException.class)
	public ResponseEntity<String> saveWordException(RuntimeException r){
		logger.info("Save word exception handller");
		return new ResponseEntity<String>(r.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(WordNotFoundException.class)
	public ResponseEntity<String> wordNotFoundException(HttpServletResponse response, RuntimeException r) throws IOException{
		
		logger.info("Word not found Exception Handller");
		//redirect to another api -> 
		response.sendRedirect("save-word-Ex");
		logger.info("After redirect");
		return new ResponseEntity<String>(r.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}
