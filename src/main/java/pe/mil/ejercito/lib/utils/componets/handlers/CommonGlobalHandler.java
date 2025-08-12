package pe.mil.ejercito.lib.utils.componets.handlers;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pe.mil.ejercito.lib.utils.componets.enums.ResponseEnum;
import pe.mil.ejercito.lib.utils.componets.exceptions.CommonException;
import pe.mil.ejercito.lib.utils.dto.Response;
import pe.mil.ejercito.lib.utils.dto.errors.ErrorDto;
import pe.mil.ejercito.lib.utils.dto.errors.ErrorResponse;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * CommonGlobalHandler
 * <p>
 * CommonGlobalHandler class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 2/03/2024
 */
@Log4j2
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonGlobalHandler {
    private final Response response;

    public CommonGlobalHandler(final Response response) {
        this.response = response;
    }


    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handlerException(final Exception ex) {
        log.debug("error handlerException {} ", ex.getMessage());
        final ErrorResponse handlerException = new ErrorResponse();
        ErrorDto dto = new ErrorDto();
        List<String> errors = new ArrayList<>();
        errors.add(ex.getLocalizedMessage());
        dto.setErrors(errors);
        dto.setInfo("error in handlerException");
        handlerException.setData(dto);
        return this.response
            .getResponse(handlerException, ResponseEnum.ERROR_INVALID_REQUEST_DATA.getCode(), headers());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public final ResponseEntity<Object> handlerConstraintViolationException(final ConstraintViolationException ex) {
        log.debug("error handlerConstraintViolationException {} ", ex.getMessage());
        final ErrorResponse error = new ErrorResponse();
        ErrorDto dto = new ErrorDto();
        dto.setErrors(ex.getConstraintViolations()
            .stream()
            .map(constraintViolation -> String.format("Field %s: %s", Objects.requireNonNull(StreamSupport.stream(constraintViolation.getPropertyPath().spliterator(), false)
                .reduce((first, second) -> second)
                .orElse(null)), constraintViolation.getMessage()))
            .collect(Collectors.toList()));
        dto.setInfo("error in handlerConstraintViolationException");
        error.setData(dto);

        return this.response
            .getResponse(error, ResponseEnum.ERROR_INVALID_REQUEST_DATA.getCode(), headers());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<Object> handlerMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex) {
        log.debug("error handlerMethodArgumentTypeMismatchException {} ", ex.getMessage());
        final ErrorResponse handlerException = new ErrorResponse();
        ErrorDto dto = new ErrorDto();
        List<String> errors = new ArrayList<>();
        errors.add(ex.getLocalizedMessage());
        dto.setErrors(errors);
        dto.setInfo("error in handlerMethodArgumentTypeMismatchException");
        handlerException.setData(dto);
        return this.response
            .getResponse(handlerException, ResponseEnum.ERROR_INVALID_REQUEST_DATA.getCode(), headers());
    }

    @ExceptionHandler({CommonException.class})
    public final ResponseEntity<Object> handlerCommonException(final CommonException ex) {
        log.debug("error handlerCommonException {} ", ex.getMessage());
        final ErrorResponse error = new ErrorResponse();
        ErrorDto dto = new ErrorDto();
        dto.setErrors(ex.getErrors());
        dto.setInfo("error in handlerCommonException");
        error.setData(dto);
        return this.response
            .getResponse(error, ex.getCode().getCode(), headers());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<Object> handlerMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        log.debug("error handlerMethodArgumentNotValidException {} ", ex.getMessage());
        final ErrorResponse error = new ErrorResponse();
        ErrorDto dto = new ErrorDto();
        List<String> errors = new ArrayList<>();
        errors.add(ex.getLocalizedMessage());
        dto.setErrors(errors);
        dto.setInfo("error in handlerMethodArgumentNotValidException");
        error.setData(dto);
        return this.response
            .getResponse(error, ResponseEnum.ERROR_INVALID_REQUEST_DATA.getCode(), headers());
    }

    @ExceptionHandler({WebExchangeBindException.class})
    public final ResponseEntity<Object> handlerWebExchangeBindException(final WebExchangeBindException ex) {
        log.debug("error handlerWebExchangeBindException {} ", ex.getMessage());
        final ErrorResponse error = new ErrorResponse();
        ErrorDto dto = new ErrorDto();
        dto.setErrors(ex.getBindingResult()
            .getFieldErrors()
            .stream().map(fieldError -> String.format("Field %s: %s", fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList()));
        dto.setInfo("error in handlerWebExchangeBindException");
        error.setData(dto);
        return this.response
            .getResponse(error, ResponseEnum.ERROR_INVALID_REQUEST_DATA.getCode(), headers());
    }

    private HttpHeaders headers() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}