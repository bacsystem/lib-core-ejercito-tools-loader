package pe.mil.ejercito.lib.utils.componets.helpers;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.mil.ejercito.lib.utils.dto.json.MessageDto;

import java.util.List;

/**
 * MessageHelper
 * <p>
 * MessageHelper class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE EJERCITO DEL PERÚ APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author ejercito
 * @author cbaciliod@ejercito.mil.pe
 * @since 1/03/2024
 */
@Log4j2
@Service
public class MessageHelper {
    @Value("${microservice.messages.path:/json/messages.json}")
    private String path;
    @Value("${microservice.messages.index:01}")
    private String index;

    private List<MessageDto> getMessages() {
        MessageTransform transform = new MessageTransform();
        return transform.loadMessages(path);
    }

    public MessageDto findCode(final String code) {
        MessageDto message = getMessages()
            .stream()
            .filter(search -> search.getCode().equals(code))
            .findFirst()
            .orElse(MessageDto.builder()
                .code("-1")
                .value("-1")
                .message("code message not mapping")
                .status(404)
                .build());
        message.setValue(message.getValue().replaceFirst("xx", this.index));
        return message;
    }
}