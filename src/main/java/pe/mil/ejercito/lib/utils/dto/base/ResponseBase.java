package pe.mil.ejercito.lib.utils.dto.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

/**
 * ResponseBase
 * <p>
 * ResponseBase class.
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
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBase implements Serializable {
    private static final long serialVersionUID = -4833927566657793752L;
    @JsonProperty(value = "code")
    @JsonbProperty(value = "code")
    private String code;
    @JsonProperty(value = "message")
    @JsonbProperty(value = "message")
    private String message;
    @JsonProperty(value = "dateTime")
    @JsonbProperty(value = "dateTime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date dateTime;

    public void setDateTime(Date dateTime) {
        this.dateTime = Optional
            .ofNullable(dateTime)
            .map(Date::getTime)
            .map(Date::new)
            .orElse(null);
    }

    public Date getDateTime() {
        return Optional
            .ofNullable(this.dateTime)
            .map(Date::getTime)
            .map(Date::new)
            .orElse(null);
    }
}