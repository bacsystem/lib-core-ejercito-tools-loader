package pe.mil.ejercito.lib.utils.constants;

import lombok.experimental.UtilityClass;

/**
 * BaseInterceptorConstant
 * <p>
 * BaseInterceptorConstant class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 3/03/2024
 */
@UtilityClass
public class BaseInterceptorConstant {
    public static final String HEADER_REQUEST_ID = "X-Request-Id";
    public static final String HEADER_EMPTY = "";
    public static final String MICROSERVICE_POD_INFO_PATH = "/podInfo";
    public static final String MICROSERVICE_ACTUATOR_PATH = "/actuator/**";
    public static final String MICROSERVICE_ACTUATOR_VALUE = "actuator";
    public static final String MICROSERVICE_SWAGGER_UI_PATH = "/swagger-ui/**";
    public static final String MICROSERVICE_SWAGGER_RESOURCES_PATH = "/swagger-resources/**";
    public static final String MICROSERVICE_SWAGGER_V2_API_DOCS_PATH = "/v2/api-docs";
    public static final String MICROSERVICE_SWAGGER_V3_API_DOCS_PATH = "/v3/api-docs";
    public static final String MICROSERVICE_HANDLER_NOT_LINK_PATH = "ERROR_HANDLER_LINK_NOT_DEFINED";
}