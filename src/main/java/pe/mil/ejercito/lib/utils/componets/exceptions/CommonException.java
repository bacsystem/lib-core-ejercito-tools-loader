package pe.mil.ejercito.lib.utils.componets.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.mil.ejercito.lib.utils.componets.enums.ResponseEnum;

import java.util.List;

/**
 * CommonException
 * <p>
 * CommonException class.
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
@EqualsAndHashCode(callSuper = true)
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -6485627657397892108L;
    private final ResponseEnum code;
    private final List<String> errors;

    public CommonException(String message, ResponseEnum code, List<String> errors) {
        super(message);
        this.code = code;
        this.errors = errors;
    }
}