package pe.mil.ejercito.lib.utils.componets.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import pe.mil.ejercito.lib.utils.dto.json.MessageDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageTransform
 * <p>
 * MessageTransform class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 2/03/2024
 */
@Log4j2
public class MessageTransform {
    public List<MessageDto> loadMessages(final String path) {
        try (InputStream is = TypeReference.class.getResourceAsStream(path)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, new ListReferences());
        } catch (IOException e) {
            log.error("error read file json: {} ", e.getMessage());
            return new ArrayList<>();
        }
    }

    private static class ListReferences extends TypeReference<List<MessageDto>> { }
}