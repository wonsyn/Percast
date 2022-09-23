package b101.percast.service;

import b101.percast.entity.MessageService;
import b101.percast.dto.message.MessageServiceSaveRequestDto;

public interface MessageServiceService {
    void sendAll();
    void save(MessageServiceSaveRequestDto requestDto);
}
