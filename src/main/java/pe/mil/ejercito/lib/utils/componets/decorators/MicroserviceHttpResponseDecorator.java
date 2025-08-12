package pe.mil.ejercito.lib.utils.componets.decorators;

import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * MicroserviceHttpResponseDecorator
 * <p>
 * MicroserviceHttpResponseDecorator class.
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
public class MicroserviceHttpResponseDecorator extends ServerHttpResponseDecorator {

    private final DataBufferFactory factory;

    public MicroserviceHttpResponseDecorator(ServerHttpResponse delegate) {
        super(delegate);
        this.factory = super.bufferFactory();
    }

    @Override
    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
        //method:
        if (body instanceof Flux) {
            return super.writeWith(Flux.from(body).map(dataBuffer -> this.factory.wrap(contentRaw(dataBuffer, body))));
        }
        if (body instanceof Mono) {
            return super.writeWith(Mono.from(body).map(dataBuffer -> this.factory.wrap(contentRaw(dataBuffer, body))));
        }
        return super.writeWith(body);
    }


    @Override
    public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
        return super.writeAndFlushWith(body);
    }

    private byte[] contentRaw(DataBuffer buffer, Publisher<? extends DataBuffer> body) {
        final byte[] bytes = new byte[buffer.readableByteCount()];
        buffer.read(bytes);
        final String content = new String(bytes, StandardCharsets.UTF_8);
        return content.getBytes(StandardCharsets.UTF_8);
    }
}