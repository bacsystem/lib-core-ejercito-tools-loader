package pe.mil.ejercito.lib.utils.constants;

import lombok.experimental.UtilityClass;

/**
 * BaseLoggerConstant
 * <p>
 * BaseLoggerConstant class.
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
public class BaseLoggerConstant {
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_REQUEST = "request";
    public static final String KEY_REQUEST_ID = "requestId";
    public static final String KEY_APPLICATION_ID = "applicationId";
    public static final String CONSTANTS_LOG_METHOD = "method";
    public static final String LOG_LEVEL = "log.level";
    public static final String HTTP_RESPONSE_FORMAT = "Response type [{}] from URL [{}] with state code [{}]";
    public static final String HTTP_REQUEST_TIME = " [{}] : [{}]";
    public static final String HTTP_REQUEST_MESSAGE = "request-start-time";
    public static final String HTTP_WRITE_AND_FLUSH_WITH_FORMAT = "response: {}, with state code[{}]";
    public static final String LOAD_MICROSERVICE_SUCCESSFULLY_FORMAT = "loaded successfully {}";
    public static final String LOAD_MICROSERVICE_LOAD_METHOD_FORMAT = "method {} initialized successfully";
    public static final String MICROSERVICE_SERVICE_NAME_FORMAT = "services name {}, serviceId {}";
    public static final String MICROSERVICE_CONTROLLER_NAME_FORMAT = "controller name {}, controllerId {}";
    public static final String MICROSERVICE_CONTROLLER_ID_FORMAT = "controllerId {}";
    public static final String MICROSERVICE_SERVICE_ID_FORMAT = "serviceId {}";
    public static final String MICROSERVICE_FINISH_FORMAT = "finish process {}";
    public static final String MICROSERVICE_FINISH_PROCESS_SERVICE_FORMAT = "finish process services {}, success: {}";
    public static final String MICROSERVICE_THIS_SERVICES_METHOD_FORMAT = "this is in services {} method";
    public static final String MICROSERVICE_PROCESS_ERROR_SERVICE_FORMAT = "exception error in process {}, error: {}";
    public static final String MICROSERVICE_PROCESS_ERROR_PARSED_FORMAT = "error general parsed object {}";
    public static final String MICROSERVICE_METHOD_INITIALIZE_FORMAT = "method query initialized successfully";
    public static final String MICROSERVICE_SERVICE_EXCEPTION_PROCESS_FORMAT = "exception error in process services, error: {}";
    public static final String MICROSERVICE_CONTROLLER_EXCEPTION_PROCESS_FORMAT = "exception error in process controller, error: {}";
    public static final String MICROSERVICE_RESPONSE_PROCESS_FORMAT = "process {} successfully completed, response: {}";
    public static final String MICROSERVICE_RESPONSE_FIND_CODE_FORMAT = "response: {} find by code : {}";
    public static final String MICROSERVICE_VALIDATION_ERROR_FORMAT = "[%s ]";
    public static final String MICROSERVICE_VALIDATION_ERROR_PROCESS_REQUEST_FORMAT = "error in process one of the required fields is not present, current instance: %s";
}