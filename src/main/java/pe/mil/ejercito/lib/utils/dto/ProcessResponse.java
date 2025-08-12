package pe.mil.ejercito.lib.utils.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.mil.ejercito.lib.utils.componets.enums.ProcessResult;
import pe.mil.ejercito.lib.utils.componets.enums.ResponseEnum;
import pe.mil.ejercito.lib.utils.dto.base.ResponseBase;

import java.util.Objects;

/**
 * ProcessResponse
 * <p>
 * ProcessResponse class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 1/03/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProcessResponse {
    private ResponseEnum message;
    private boolean success;
    private boolean empty;
    private ResponseBase response;
    private ProcessResult result;

    public static ProcessResponse success(final ResponseBase response) {
        return ProcessResponse.builder()
            .result(ProcessResult.PROCESS_SUCCESS)
            .message(ResponseEnum.SUCCESS)
            .success(true)
            .empty(false)
            .response(response)
            .build();
    }

    public static ProcessResponse empty(final ResponseBase response) {
        return ProcessResponse.builder()
            .result(ProcessResult.PROCESS_SUCCESS)
            .message(ResponseEnum.SUCCESS)
            .success(true)
            .empty(true)
            .response(response)
            .build();
    }

    public static ProcessResponse error(final ResponseEnum code) {
        return ProcessResponse.builder()
            .result(ProcessResult.PROCESS_FAILED)
            .message(code)
            .success(false)
            .empty(false)
            .build();
    }

    public static ProcessResponse error(final ResponseEnum code, final ResponseBase response) {
        return ProcessResponse.builder()
            .result(ProcessResult.PROCESS_FAILED)
            .message(code)
            .success(false)
            .empty(false)
            .response(response)
            .build();
    }

    public boolean isError() {
        return !success;
    }

    public boolean exist() {
        return !Objects.isNull(response);
    }
}