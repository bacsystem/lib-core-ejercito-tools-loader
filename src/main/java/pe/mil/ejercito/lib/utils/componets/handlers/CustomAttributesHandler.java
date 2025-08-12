package pe.mil.ejercito.lib.utils.componets.handlers;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import pe.mil.ejercito.lib.utils.componets.exceptions.CommonException;

import java.util.HashMap;
import java.util.Map;

/**
 * CustomAttributesHandler
 * <p>
 * CustomAttributesHandler class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 25/03/2024
 */
@Log4j2
@Component
public class CustomAttributesHandler extends DefaultErrorAttributes {
    public CustomAttributesHandler() {
        super();
    }

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>();
        Throwable throwable = super.getError(request);
        if (throwable instanceof CommonException) {
            CommonException customException = (CommonException) throwable;
            errorAttributes.put("code", customException.getCode().getCode());
            errorAttributes.put("error", customException.getMessage());
            log.error("error message {} code {}, find list errors.", customException.getMessage(), customException.getCode().getCode());
        }
        return errorAttributes;
    }
}


