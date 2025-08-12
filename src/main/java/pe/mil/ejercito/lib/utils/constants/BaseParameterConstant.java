package pe.mil.ejercito.lib.utils.constants;

import lombok.experimental.UtilityClass;

/**
 * BaseParameterConstant
 * <p>
 * BaseParameterConstant class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 3/01/2024
 */

@UtilityClass
public class BaseParameterConstant {
    public static final String COMPONENT_SERVER_SERVLET_CONTEXT_PATH = "component-server-servlet-context-path-not-available";
    public static final String MICROSERVICES_CONTEXT_NOT_FOUND_MESSAGE = "microservices context not available";
    public static final String PARAMETER_UUID_REGEX_VALIDATION = "[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}";
}


