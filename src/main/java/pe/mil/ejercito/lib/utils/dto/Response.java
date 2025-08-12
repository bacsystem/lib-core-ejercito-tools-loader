package pe.mil.ejercito.lib.utils.dto;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pe.mil.ejercito.lib.utils.componets.helpers.MessageHelper;
import pe.mil.ejercito.lib.utils.dto.base.ResponseBase;
import pe.mil.ejercito.lib.utils.dto.json.MessageDto;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.Date;

/**
 * Response
 * <p>
 * Response class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 1/03/2024
 */
@Log4j2
@Validated
@Component
public class Response {
    private final MessageHelper helper;

    public Response(final MessageHelper helper) {
        this.helper = helper;
    }

    public ResponseEntity<Object> getResponse(final ResponseBase response, final String code, HttpHeaders headers) {
        return buildResponse(response, code, headers);
    }

    public ResponseEntity<Object> getResponse(final ResponseBase response, final String code) {
        return buildResponse(response, code, null);
    }

    public ResponseEntity<Object> getResponse(final String code, HttpHeaders headers) {
        return buildResponse(new ResponseBase(), code, headers);
    }

    public ResponseEntity<Object> getResponse(final String code) {
        return buildResponse(new ResponseBase(), code, null);
    }

    private ResponseEntity<Object> buildResponse(final ResponseBase response, final String code, final HttpHeaders headers) {

        try (Jsonb jsonb = JsonbBuilder.create()) {
            final MessageDto message = this.helper.findCode(code);
            response.setDateTime(new Date());
            response.setCode(message.getValue());
            response.setMessage(message.getMessage());
            final HttpStatus status = HttpStatus.valueOf(message.getStatus());
            final String body = jsonb.toJson(response);
            if (headers != null) {
                return new ResponseEntity<>(body, headers, status);
            }
            return new ResponseEntity<>(body, status);

        } catch (Exception e) {
            log.error("error response in process {}", e.getMessage());
        }
        if (headers != null) {
            return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}