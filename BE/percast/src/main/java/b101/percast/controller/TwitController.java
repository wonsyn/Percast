package b101.percast.controller;

import b101.percast.dto.twit.TwitFindAllResponseDto;
import b101.percast.service.TwitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/twit")
@RequiredArgsConstructor
public class TwitController {

    private final TwitService twitService;

    @GetMapping
    public List<TwitFindAllResponseDto> getNotices() {
        return twitService.getTwits();
    }

}
