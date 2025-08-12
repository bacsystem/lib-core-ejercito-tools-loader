package pe.mil.ejercito.lib.utils.dto.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.mil.ejercito.lib.utils.dto.base.ResponseBase;

import java.io.Serializable;

/**
 * ErrorResponse
 * <p>
 * ErrorResponse class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 2/03/2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse extends ResponseBase implements Serializable {
    private static final long serialVersionUID = 7585695001779135262L;
    private ErrorDto data;
}