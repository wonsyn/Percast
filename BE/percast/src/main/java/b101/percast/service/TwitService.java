package b101.percast.service;

import b101.percast.dto.twit.TwitFindAllResponseDto;

import java.util.List;

public interface TwitService {
    List<TwitFindAllResponseDto> getTwits(String disease);
}
