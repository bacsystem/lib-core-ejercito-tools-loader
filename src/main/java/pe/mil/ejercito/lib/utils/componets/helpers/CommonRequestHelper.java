package pe.mil.ejercito.lib.utils.componets.helpers;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;
import java.util.regex.Pattern;

import static pe.mil.ejercito.lib.utils.constants.BaseParameterConstant.PARAMETER_UUID_REGEX_VALIDATION;

/**
 * CommonRequestHelper
 * <p>
 * CommonRequestHelper class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 1/03/2024
 */

@UtilityClass
public class CommonRequestHelper {
    private static final Long ID_ZERO_VALUE = 0L;

    public static Boolean isValidId(final Long id) {

        if (Objects.isNull(id) || ID_ZERO_VALUE.equals(id)) {
            return false;
        }

        return id > ID_ZERO_VALUE;
    }

    public static Boolean isInvalidId(final Long id) {
        return !isValidId(id);
    }

    public static Boolean isValidUuId(final String uuId) {

        if (ObjectUtils.isEmpty(uuId)) {
            return false;
        }

        final Pattern patternUuIdRegex = Pattern.compile(PARAMETER_UUID_REGEX_VALIDATION);
        return patternUuIdRegex.matcher(uuId).matches();
    }

    public static Boolean isInvalidUuId(final String uuId) {
        return !isValidUuId(uuId);
    }

    public static Boolean isInvalidCode(final String code) {
        return ObjectUtils.isEmpty(code);
    }
    public static Boolean isInvalidUsername(final String username) {
        return ObjectUtils.isEmpty(username);
    }
}