package pe.mil.ejercito.lib.utils.base;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import pe.mil.ejercito.lib.utils.componets.properties.MicroserviceProperties;
import pe.mil.ejercito.lib.utils.constants.BaseParameterConstant;

import java.util.Objects;

/**
 * MicroserviceBaseApplication
 * <p>
 * MicroserviceBaseApplication class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 3/01/2024
 */

@Log4j2
@Configuration
@EnableConfigurationProperties(MicroserviceProperties.class)
@EnableAutoConfiguration
public class MicroserviceBaseApplication implements ApplicationListener<ContextRefreshedEvent> {

    private final MicroserviceProperties microserviceProperties;

    public MicroserviceBaseApplication(final MicroserviceProperties microserviceProperties) {
        this.microserviceProperties = microserviceProperties;
    }

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        log.info("************************ MICROSERVICE APP EJERCITO DEL PERÚ ************************************");
        log.info("Spring Version: {}", this.microserviceProperties.getSpring());
        log.info("Application Name: {}", this.microserviceProperties.getName());
        log.info("Application Version: {}", this.microserviceProperties.getVersion());
        final String context = findMicroservicesContext();
        log.info("Application Context: {}", context);
        log.info("Application Port: {}", this.microserviceProperties.getPort());
        log.info("Application Developer: {}", this.microserviceProperties.getNickname());
        log.info("Microservice load success.");
        log.info("************************ MICROSERVICE APP EJERCITO DEL PERÚ ************************************");
    }

    private String findMicroservicesContext() {
        if (Objects.nonNull(this.microserviceProperties.getContextPath())
            && StringUtils.isNoneEmpty(this.microserviceProperties.getContextPath())
            && !BaseParameterConstant.COMPONENT_SERVER_SERVLET_CONTEXT_PATH.equals(this.microserviceProperties.getContextPath())) {
            log.info("Application Project: synchronous project");
            return this.microserviceProperties.getContextPath();
        }

        if (Objects.nonNull(this.microserviceProperties.getContextPathFlux())
            && StringUtils.isNoneEmpty(this.microserviceProperties.getContextPathFlux())
            && !BaseParameterConstant.COMPONENT_SERVER_SERVLET_CONTEXT_PATH.equals(this.microserviceProperties.getContextPathFlux())) {
            log.info("Application Project: asynchronous project");
            return this.microserviceProperties.getContextPathFlux();
        }
        return BaseParameterConstant.MICROSERVICES_CONTEXT_NOT_FOUND_MESSAGE;
    }
}
