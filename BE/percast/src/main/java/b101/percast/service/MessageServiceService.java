package b101.percast.service;

import b101.percast.dto.message.MessageServiceFindAllByTelResponseDto;
import b101.percast.dto.message.MessageServiceSaveRequestDto;

import java.util.List;

public interface MessageServiceService {
    void sendAll();
    void save(MessageServiceSaveRequestDto requestDto);

    List<MessageServiceFindAllByTelResponseDto> findAllByTel(String tel);

    void delete(Long id);
}
