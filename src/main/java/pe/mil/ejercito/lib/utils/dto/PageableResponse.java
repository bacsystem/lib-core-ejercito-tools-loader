package pe.mil.ejercito.lib.utils.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pe.mil.ejercito.lib.utils.dto.base.ResponseBase;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;

/**
 * PageableResponse
 * <p>
 * PageableResponse class.
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
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageableResponse<T> extends ResponseBase implements Serializable {
    private static final long serialVersionUID = -931968592294080840L;
    @JsonProperty(value = "data")
    @JsonbProperty(value = "data")
    protected T data;

    @JsonbProperty("metadata")
    @JsonProperty("metadata")
    private MetadataDto metadata;
}