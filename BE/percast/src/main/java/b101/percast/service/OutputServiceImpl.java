package b101.percast.service;

import b101.percast.api.ApiExplorer;
import b101.percast.dto.output.OutputFindAllResponseDto;
import b101.percast.entity.Output;
import b101.percast.repository.OutputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OutputServiceImpl implements OutputService {
    private final OutputRepository outputRepository;

    @Override
    public List<OutputFindAllResponseDto> findAll() {
        return outputRepository.findAll().stream().map(OutputFindAllResponseDto::new)
                .collect(Collectors.toList());
    }

//    @Scheduled(cron = "0 36 * * * ?")
    @Scheduled(cron = "0 54 * * * ?")
    public void saveFoodPoison() throws IOException {
        save(ApiExplorer.getFoodPoison());
    }

    @Override
    public void save(List<String> list) {
        List<Output> outputList = outputRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            Output output = outputList.get(i);
            output.updateFoodPoison(Double.parseDouble(list.get(i)));
        }
        outputRepository.saveAll(outputList);
    }
}
