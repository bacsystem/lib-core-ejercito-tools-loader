package pe.mil.ejercito.lib.utils.controllers.base;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import pe.mil.ejercito.lib.utils.componets.enums.ResponseEnum;
import pe.mil.ejercito.lib.utils.constants.BaseLoggerConstant;
import pe.mil.ejercito.lib.utils.dto.ProcessResponse;
import pe.mil.ejercito.lib.utils.dto.Response;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

/**
 * ReactorControllerBase
 * <p>
 * ReactorControllerBase class.
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
@Getter
public class ReactorControllerBase {
    private final Response response;
    private final String controllerId;
    private final Gson gson;

    public ReactorControllerBase(final Response response, final String name) {
        this.response = response;
        this.controllerId = UUID.randomUUID().toString();
        this.gson = new Gson();
        log.debug(BaseLoggerConstant.MICROSERVICE_CONTROLLER_NAME_FORMAT, name, this.controllerId);
        log.debug(BaseLoggerConstant.LOAD_MICROSERVICE_SUCCESSFULLY_FORMAT, name);
    }

    public Mono<ResponseEntity<Object>> response(ProcessResponse processResponse) {
        return Mono.just(processResponse)
            .flatMap(process -> {
                if (process.isError() && Objects.isNull(process.getResponse())) {
                    log.debug("response: {}", this.gson.toJson(this.response.getResponse(process.getMessage().getCode())));
                    return Mono.just(this.response.getResponse(process.getMessage().getCode()));
                }
                if (process.isEmpty()) {
                    return Mono.just(this.response.getResponse(process.getResponse().getCode()));
                }
                log.debug("response: {}", this.gson.toJson(this.response.getResponse(process.getMessage().getCode())));
                return Mono.just(this.response.getResponse(process.getResponse(), process.getMessage().getCode()));
            }).onErrorResume(throwable -> Mono.just(this.response.getResponse(ResponseEnum.INTERNAL_SERVER_ERROR.getCode())));
    }
}