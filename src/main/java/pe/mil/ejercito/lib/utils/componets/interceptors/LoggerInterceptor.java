package pe.mil.ejercito.lib.utils.componets.interceptors;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import pe.mil.ejercito.lib.utils.componets.decorators.MicroserviceHttpRequestDecorator;
import pe.mil.ejercito.lib.utils.componets.decorators.MicroserviceHttpResponseDecorator;
import pe.mil.ejercito.lib.utils.constants.BaseInterceptorConstant;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;

import static pe.mil.ejercito.lib.utils.constants.BaseLoggerConstant.KEY_REQUEST;
import static pe.mil.ejercito.lib.utils.constants.BaseLoggerConstant.KEY_REQUEST_ID;

/**
 * LoggerInterceptor
 * <p>
 * LoggerInterceptor class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 20/02/2024
 */

@Log4j2
@Component
public class LoggerInterceptor implements WebFilter {
    @Override
    public Mono<Void> filter(@NotNull ServerWebExchange exchange, @NotNull WebFilterChain chain) {
        log.debug("ServerWebExchange is {}", exchange.getRequest().getPath());
        if (Boolean.TRUE.equals(CommonInterceptorHelper.validateCommonHealthEndPoint.apply(exchange))) {
            log.debug("ServerWebExchange is null {}", exchange);
            return chain.filter(exchange.mutate().build());
        }

        final String requestId = StringUtils
            .defaultIfEmpty(exchange
                .getRequest()
                .getHeaders()
                .getFirst(BaseInterceptorConstant.HEADER_REQUEST_ID), CommonInterceptorHelper.generatePathRequestId());

        ThreadContext.put(KEY_REQUEST_ID, requestId);

        return chain
            .filter(exchange.mutate()
                .request(new MicroserviceHttpRequestDecorator(exchange.getRequest()))
                .response(new MicroserviceHttpResponseDecorator(exchange.getResponse()))
                .build())
            .contextWrite(context -> context.put(KEY_REQUEST, exchange.getRequest()))
            .contextWrite(context -> context.put(KEY_REQUEST_ID, requestId));
    }
}