package com.proj.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.proj.blog.payloads.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
		
		String message=ex.getMessage();
		ApiResponse res=new ApiResponse(message,false);
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
		
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Api_Response> methodArgumentNotValidException(MethodArgumentNotValidException ex){
//		Api_Response resp= new Api_Response();
//		Map<String, String> resp= new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error)->
//		{
//			String fieldName=((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			resp.put(fieldName, message);
//			resp.setMessage(message);
//			Api_Response.setStatus("false");
//		Api_Response.setData(fieldName);
//		});
//		return new ResponseEntity<Api_Response>(Api_Response, HttpStatus.NOT_ACCEPTABLE);                    }    
//
//

}
