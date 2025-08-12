package pe.mil.ejercito.lib.utils.componets.handlers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import pe.mil.ejercito.lib.utils.componets.enums.ResponseEnum;
import pe.mil.ejercito.lib.utils.dto.ProcessResponse;
import reactor.core.publisher.Mono;

/**
 * CommonProcessHandler
 * <p>
 * CommonProcessHandler class.
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
@Component
public class CommonProcessHandler {

    public Mono<ProcessResponse> processErrorHandler() {
        return Mono.just(ProcessResponse.error(ResponseEnum.INTERNAL_SERVER_ERROR));
    }

    public Mono<ProcessResponse> processErrorHandler(ResponseEnum message) {
        return Mono.just(ProcessResponse.error(message));
    }
}