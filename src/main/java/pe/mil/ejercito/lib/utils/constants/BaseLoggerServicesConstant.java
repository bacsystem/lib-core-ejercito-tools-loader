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
public class BaseLoggerServicesConstant {
    public static final String MICROSERVICE_SERVICE_NAME_FORMAT = "services name {}, serviceId {}";
    public static final String MICROSERVICE_SERVICE_ID_FORMAT = "serviceId {}";
    public static final String LOAD_MICROSERVICE_SERVICE_SUCCESSFULLY_FORMAT = "loaded service successfully {}";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_ALL_FORMAT_SUCCESS = "success in process getAllEntities";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_ID_INVALID_FORMAT_ERROR = "error in process getByIdEntity, the id is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_ID_FORMAT_SUCCESS = "success in process getByIdEntity";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_ID_NOT_EXIST_FORMAT_ERROR = "error in process findByUuId, the id not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_UUID_INVALID_FORMAT_ERROR = "error in process getByUuIdEntity, the uuId is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_CODE_INVALID_FORMAT_ERROR = "error in process getByCodeEntity, the code is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_DOCUMENT_INVALID_FORMAT_ERROR = "error in process getByDocument, the document is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_UUID_FORMAT_SUCCESS = "success in process getByUuIdEntity";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_CODE_FORMAT_SUCCESS = "success in process getByCodeEntity";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_DOCUMENT_FORMAT_SUCCESS = "success in process getByDocument";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_UUID_NOT_EXIST_FORMAT_ERROR = "error in process getByUuIdEntity, the uuId not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_CODE_NOT_EXIST_FORMAT_ERROR = "error in process getByCodeEntity, the code not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_FIND_BY_DOCUMENT_NOT_EXIST_FORMAT_ERROR = "error in process getByDocument, the person not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_FORMAT_SUCCESS = "success in process saveEntity";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_UPDATE_FORMAT_SUCCESS = "success in process updateEntity";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_VALIDATION_REQUEST_FORMAT_ERROR = "error in process doOnValidateSaveRequest, the request is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_VALIDATION_REQUEST_FORMAT_SUCCESS = "success in process doOnValidateSaveRequest";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_ON_SAVE_FORMAT_SUCCESS = "success in process doOnSave";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_UPDATE_VALIDATION_REQUEST_FORMAT_ERROR = "error in process doOnValidateUpdateRequest, the request is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_UPDATE_VALIDATION_FORMAT_SUCCESS = "success in process doOnValidateUpdateRequest";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_ON_UPDATE_FORMAT_SUCCESS = "success in process doOnUpdate";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_ON_UPDATE_BY_UUID_NOT_EXIST_FORMAT_ERROR = "error in process doOnUpdate, the uuId not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_ON_UPDATE_BY_UUID_INVALID_FORMAT_ERROR = "error in process doOnUpdate, the uuId is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_OR_UPDATE_VALIDATION_RESPONSE_FORMAT_ERROR = "error in process doOnValidateResponse, the request is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_OR_UPDATE_VALIDATION_RESPONSE_FORMAT_SUCCESS = "success in process doOnValidateResponse";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_DELETE_BY_UUID_INVALID_FORMAT_ERROR = "error in process deleteByUuIdEntity, the uuId is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_DELETE_BY_UUID_NOT_EXIST_FORMAT_ERROR = "error in process deleteByUuIdEntity, the uuId not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_DELETE_BY_UUID_FORMAT_SUCCESS = "success in process deleteByUuIdEntity";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_FIND_BY_UUID_INVALID_FORMAT_ERROR = "error in process doOnSave, the uuId is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_FIND_BY_UUID_NOT_EXIST_FORMAT_ERROR = "error in process doOnSave, the uuId not exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_SAVE_FIND_BY_USERNAME_EXIST_FORMAT_ERROR = "error in process doOnSave, the user exists";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_UPDATE_FIND_BY_UUID_INVALID_FORMAT_ERROR = "error in process doOnUpdate, the uuId is invalid";
    public static final String MICROSERVICE_SERVICE_DOMAIN_ENTITY_UPDATE_FIND_BY_UUID_NOT_EXIST_FORMAT_ERROR = "error in process doOnUpdate, the uuId not exists";
}