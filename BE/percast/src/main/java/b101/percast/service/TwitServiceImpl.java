package b101.percast.service;

import b101.percast.dto.twit.TwitFindAllResponseDto;
import b101.percast.entity.Twit;
import b101.percast.repository.TwitRepository;
import b101.percast.repository.disease.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TwitServiceImpl implements TwitService {

    private final TwitRepository twitRepository;
    private final AsthmaOutputRepository asthmaOutputRepository;
    private final ColdOutputRepository coldOutputRepository;
    private final EyeDiseaseOutputRepository eyeDiseaseOutputRepository;
    private final FoodPoisoningOutputRepository foodPoisoningOutputRepository;
    private final SkinDiseaseOutputRepository skinDiseaseOutputRepository;

    @Override
    public List<TwitFindAllResponseDto> getTwits() {
        return twitRepository.findAll()
                .stream().map(TwitFindAllResponseDto::new)
                .collect(Collectors.toList());
    }


    @Scheduled(cron = "* 6 6 * * ?")
    public void saveDiseaseOutput() {
        diseaseOutput(Arrays.stream(asthmaOutputRepository.findAll().toArray()));
        diseaseOutput(Arrays.stream(coldOutputRepository.findAll().toArray()));
        diseaseOutput(Arrays.stream(eyeDiseaseOutputRepository.findAll().toArray()));
        diseaseOutput(Arrays.stream(foodPoisoningOutputRepository.findAll().toArray()));
        diseaseOutput(Arrays.stream(skinDiseaseOutputRepository.findAll().toArray()));
    }

    private void diseaseOutput(Stream<Object> stream) {
        Map<String, Integer> map = new HashMap<>();
        stream.map(outputObject -> outputObject.toString().split("a"))
                .map(stringArray -> map.put(stringArray[1], Integer.parseInt(stringArray[0])));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            twitRepository.save(Twit.builder()
                    .disease("asthma")
                    .count(Long.valueOf(entry.getValue()))
                    .keyword(entry.getKey())
                    .build());
        }

    }

}
