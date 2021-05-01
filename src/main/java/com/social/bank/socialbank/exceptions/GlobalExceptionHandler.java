package com.social.bank.socialbank.exceptions;

import com.social.bank.socialbank.controller.commons.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
@Slf4j
@PropertySource("classpath:messages.properties")
public class GlobalExceptionHandler {
    public static final int STR_FIELD_NAME = 0;
    public static final int IGNORE_DOT_POST = 1;

    @Autowired
    private Environment env;

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    List<ErrorResponse> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        List<ErrorResponse> validationErrors = new ArrayList<>();

        for (ObjectError error : exception.getBindingResult().getAllErrors()) {

            if (nonNull(error.getCodes()) && nonNull(error.getCodes()[STR_FIELD_NAME])) {
                String fieldName = error.getCodes()[STR_FIELD_NAME];

                StringBuilder messageDisplayed = new StringBuilder();
                messageDisplayed.append("[");
                messageDisplayed
                        .append(fieldName.substring(fieldName.lastIndexOf(".") + IGNORE_DOT_POST).toUpperCase());
                messageDisplayed.append("] - ");
                messageDisplayed.append(error.getDefaultMessage());

                validationErrors.add(new ErrorResponse(messageDisplayed.toString()));
            }
        }

        return validationErrors;
    }

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler({DocumentAlreadyExistsException.class})
    public @ResponseBody
    ErrorResponse handlerBusinessRules(DocumentAlreadyExistsException exception) {
        log.info(exception.getMessage());
        return new ErrorResponse(env.getProperty("validation.document.already.exists"));
    }
}
