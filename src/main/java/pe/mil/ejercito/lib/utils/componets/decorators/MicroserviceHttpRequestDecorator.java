package pe.mil.ejercito.lib.utils.componets.decorators;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import reactor.core.publisher.Flux;

/**
 * MicroserviceHttpRequestDecorator
 * <p>
 * MicroserviceHttpRequestDecorator class.
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
public class MicroserviceHttpRequestDecorator extends ServerHttpRequestDecorator {
    public MicroserviceHttpRequestDecorator(ServerHttpRequest delegate) {
        super(delegate);
    }

    @Override
    public Flux<DataBuffer> getBody() {
        log.info("Request from [{}]", super.getPath());
        return super.getBody();
    }

}