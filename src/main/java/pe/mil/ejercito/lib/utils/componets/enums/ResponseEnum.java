package pe.mil.ejercito.lib.utils.componets.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * ResponseEnum
 * <p>
 * ResponseEnum enum.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 1/03/2024
 */
@Getter
public enum ResponseEnum {
    SUCCESS("000"),
    CREATE_RESOURCES_SUCCESS("001"),
    ERROR_INVALID_DATA_ENTITY_ID("002"),
    ERROR_INVALID_DATA_ENTITY_UUID("003"),
    NOT_FOUNT_ENTITY("004"),
    ERROR_INVALID_REQUEST_DATA("005"),
    ERROR_INVALID_JWT("006"),
    ERROR_UNAUTHORIZED("007"),
    ERROR_INVALID_REQUEST_AUTHENTICATE("008"),
    ERROR_INVALID_RESPONSE_DATA("009"),
    ERROR_INVALID_FILE_EXTENSION("010"),
    ERROR_INVALID_SAVE_DOCUMENT("011"),
    ERROR_LOAD_CONFIGURATION_JSON("012"),
    ERROR_NOT_FOUND_TYPE_REGISTER("013"),
    ERROR_NOT_FOUND_PERIOD("014"),
    ERROR_NOT_FOUND_UNIT_CONFIGURATION("015"),
    ERROR_NOT_FOUND_UNIT("016"),
    ERROR_CREATE_FILE_EXCEL_WORKBOOK("017"),
    ERROR_NOT_FOUND_FILE_EXCEL_WORKBOOK("018"),
    ERROR_READ_FILE_EXCEL_WORKBOOK("019"),
    ERROR_DELETE_FILE_EXCEL_WORKBOOK("020"),
    ERROR_INVALID_SAVE_DOCUMENT_STATISTIC_DATA("021"),
    ERROR_INVALID_DATA_ENTITY_DOCUMENT("022"),
    REGISTERED_USER_ENTITY("023"),
    ERROR_INVALID_DATA_ENTITY_CODE("024"),
    INTERNAL_SERVER_ERROR("999");
    private final String code;
    private static final Map<String, ResponseEnum> ENUM_MAP = new HashMap<>();

    ResponseEnum(String code) {
        this.code = code;
    }

    static {
        for (final ResponseEnum re : EnumSet.allOf(ResponseEnum.class)) {
            ENUM_MAP.put(re.getCode(), re);
        }
    }

    public static ResponseEnum findByCode(final String code) {
        return StringUtils.isNoneBlank(code) ? ENUM_MAP.get(code) : null;
    }

    public static Boolean exist(final String code) {
        return StringUtils.isNoneBlank(code) && ENUM_MAP.containsKey(code);
    }
}