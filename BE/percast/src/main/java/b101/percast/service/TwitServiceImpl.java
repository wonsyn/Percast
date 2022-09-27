package b101.percast.service;

import b101.percast.dto.twit.TwitFindAllResponseDto;
import b101.percast.entity.Twit;
import b101.percast.entity.disease.*;
import b101.percast.repository.TwitRepository;
import b101.percast.repository.disease.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TwitFindAllResponseDto> getTwits(String disease) {
        return twitRepository.findTop10ByDiseaseOrderByCountDesc(disease)
                .stream().map(TwitFindAllResponseDto::new)
                .collect(Collectors.toList());
    }

    @Scheduled(cron = "0 6 6 * * ?")
    public void saveDiseaseOutput() {
        List<Twit> resList = new ArrayList<>();

        List<FoodPoisoningOutput> foodPoisoningOutputs = foodPoisoningOutputRepository.findAll();
        for(FoodPoisoningOutput beforeString : foodPoisoningOutputs){
            String[] arr = beforeString.getResult().split("a");
            resList.add(Twit.builder()
                    .disease("foodPoison")
                    .count(Long.valueOf(arr[0].trim()))
                    .keyword(arr[1])
                    .build());
        }

        List<AsthmaOutput> asthmaOutputs = asthmaOutputRepository.findAll();
        for(AsthmaOutput beforeString : asthmaOutputs){
            String[] arr = beforeString.getResult().split("a");
            resList.add(Twit.builder()
                    .disease("asthma")
                    .count(Long.valueOf(arr[0].trim()))
                    .keyword(arr[1])
                    .build());
        }

        List<ColdOutput> coldOutputs = coldOutputRepository.findAll();
        for(ColdOutput beforeString : coldOutputs){
            String[] arr = beforeString.getResult().split("a");
            resList.add(Twit.builder()
                    .disease("cold")
                    .count(Long.valueOf(arr[0].trim()))
                    .keyword(arr[1])
                    .build());
        }


        List<EyeDiseaseOutput> eyeDiseaseOutputs = eyeDiseaseOutputRepository.findAll();
        for(EyeDiseaseOutput beforeString : eyeDiseaseOutputs){
            String[] arr = beforeString.getResult().split("a");
            resList.add(Twit.builder()
                    .disease("eye")
                    .count(Long.valueOf(arr[0].trim()))
                    .keyword(arr[1])
                    .build());
        }


        List<SkinDiseaseOutput> skinDiseaseOutputs = skinDiseaseOutputRepository.findAll();
        for(SkinDiseaseOutput beforeString : skinDiseaseOutputs){
            String[] arr = beforeString.getResult().split("a");
            resList.add(Twit.builder()
                    .disease("skin")
                    .count(Long.valueOf(arr[0].trim()))
                    .keyword(arr[1])
                    .build());
        }

        twitRepository.deleteAll();
        twitRepository.saveAll(resList);
    }
}
