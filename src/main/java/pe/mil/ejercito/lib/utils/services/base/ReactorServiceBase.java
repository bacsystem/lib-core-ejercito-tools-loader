package pe.mil.ejercito.lib.utils.services.base;

import lombok.extern.log4j.Log4j2;
import pe.mil.ejercito.lib.utils.constants.BaseLoggerServicesConstant;

import java.util.UUID;

/**
 * ReactorServiceBase
 * <p>
 * ReactorServiceBase class.
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
public abstract class ReactorServiceBase {

    protected ReactorServiceBase(final String serviceName) {
        String serviceUuId = UUID.randomUUID().toString();
        log.debug(BaseLoggerServicesConstant.MICROSERVICE_SERVICE_NAME_FORMAT, serviceName, serviceUuId);
        log.debug(BaseLoggerServicesConstant.LOAD_MICROSERVICE_SERVICE_SUCCESSFULLY_FORMAT, serviceName, serviceName);
    }
}