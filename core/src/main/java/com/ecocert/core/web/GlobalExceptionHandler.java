package com.ecocert.core.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	private static final AtomicInteger ERROR_ID = new AtomicInteger();

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String error(HttpServletRequest request, Exception e) {
		int errorId = ERROR_ID.incrementAndGet();

		String errorKey = e.getMessage();
		String errorMessage = messageSource.getMessage(errorKey, null, "NOT_FOUND", request.getLocale());

		if ("NOT_FOUND".equals(errorMessage)) {
			errorMessage = messageSource.getMessage("error.internal", new Object[]{errorId}, request.getLocale());
		}

		log.error("ERROR #" + errorId, e.getMessage(), e);
		return errorMessage;
	}
}
