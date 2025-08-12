package pe.mil.ejercito.lib.utils.componets.interceptors;

import lombok.experimental.UtilityClass;
import org.springframework.http.server.PathContainer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;
import pe.mil.ejercito.lib.utils.constants.BaseInterceptorConstant;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

/**
 * CommonInterceptorHelper
 * <p>
 * CommonInterceptorHelper class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 26/02/2024
 */
@UtilityClass
public class CommonInterceptorHelper {

    public static final Function<ServerWebExchange, Boolean> validateActuator = (serverWebExchange ->
        !Objects.isNull(serverWebExchange) && serverWebExchange.getRequest().getURI().getPath().contains(BaseInterceptorConstant.MICROSERVICE_ACTUATOR_VALUE));
    public static final Function<ServerWebExchange, Boolean> validateCommonHealthEndPoint = (serverWebExchange -> {
        if (Objects.isNull(serverWebExchange)) {
            return false;
        } else {
            PathContainer pathContainer = PathContainer
                .parsePath(serverWebExchange
                    .getRequest()
                    .getPath()
                    .pathWithinApplication()
                    .value());
            return new PathPatternParser().parse(BaseInterceptorConstant.MICROSERVICE_ACTUATOR_PATH).matches(pathContainer)
                || new PathPatternParser().parse(BaseInterceptorConstant.MICROSERVICE_POD_INFO_PATH).matches(pathContainer)
                || new PathPatternParser().parse(BaseInterceptorConstant.MICROSERVICE_SWAGGER_UI_PATH).matches(pathContainer)
                || new PathPatternParser().parse(BaseInterceptorConstant.MICROSERVICE_SWAGGER_RESOURCES_PATH).matches(pathContainer)
                || new PathPatternParser().parse(BaseInterceptorConstant.MICROSERVICE_SWAGGER_V2_API_DOCS_PATH).matches(pathContainer)
                || new PathPatternParser().parse(BaseInterceptorConstant.MICROSERVICE_SWAGGER_V3_API_DOCS_PATH).matches(pathContainer);
        }
    });

    public static String generatePathRequestId() {
        return String.format("%s%s", "ejercito", UUID.randomUUID()).toUpperCase(Locale.getDefault());
    }
}