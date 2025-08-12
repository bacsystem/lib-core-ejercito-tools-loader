package pe.mil.ejercito.lib.utils.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * PageableDto
 * <p>
 * PageableDto class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 9/03/2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageableDto implements Serializable {
    private static final long serialVersionUID = 4376439836875747681L;
    private String total;
    private String limit;
    private String currentPage;
    private String totalPages;
    private String numberOfElements;
    private String size;
    private String number;
    private String lastPage;
    private String firstPageUrl;
    private String lastPageUrl;
    private String nextPageUrl;
    private String prevPageUrl;
    private String from;
    private String to;
}


