package pe.mil.ejercito.lib.utils.componets.validations;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.mil.ejercito.lib.utils.componets.enums.ProcessResult;

import java.io.Serializable;
import java.util.List;

/**
 * ProcessValidationResult
 * <p>
 * ProcessValidationResult class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 4/03/2024
 */

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProcessValidationResult implements Serializable {
    private static final long serialVersionUID = 1233215479204442616L;
    private ProcessResult processResult;
    private List<String> errors;
}