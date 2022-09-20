package b101.percast.service;

import b101.percast.dto.twit.TwitFindAllResponseDto;
import b101.percast.repository.TwitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TwitServiceImpl implements TwitService{

    private final TwitRepository twitRepository;

    @Override
    public List<TwitFindAllResponseDto> getTwits() {
        return twitRepository.findAll()
                .stream().map(TwitFindAllResponseDto::new)
                .collect(Collectors.toList());
    }
}
