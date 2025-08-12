package pe.mil.ejercito.lib.utils.componets.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MicroserviceProperties
 * <p>
 * MicroserviceProperties class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 3/01/2024
 */
@Data
@Component(value = "microserviceProperties")
@ConfigurationProperties(prefix = "developer")
public class MicroserviceProperties {

    @Value("${spring.application.name:component name not available}")
    private String name;
    @Value("${spring.application.version:component version not available}")
    private String version;
    @Value("${spring.version:spring version not available}")
    private String spring;
    @Value("${server.port:8000}")
    private Integer port;
    @Value("${server.servlet.context-path:component-server-servlet-context-path-not-available}")
    private String contextPath;
    @Value("${spring.webflux.base-path:component-spring-webflux-base-path-not-available}")
    private String contextPathFlux;
    private String nickname;
}