package b101.percast.service;

import b101.percast.Exception.InputNotFoundException;
import b101.percast.api.ApiExplorer;
import b101.percast.dto.input.InputFindResponse;
import b101.percast.dto.input.InputSaveRequest;
import b101.percast.entity.Input;
import b101.percast.repository.InputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class InputServiceImpl implements InputService{
    private final InputRepository inputRepository;

//    @Scheduled(cron = "0 24 * * * ?")
    @Scheduled(cron = "0 58 * * * ?")
    @Transactional
    @Override
    public void saveInputData() throws IOException {
        InputSaveRequest[] dtoList = ApiExplorer.getDtoList();
        for(int i = 0; i < dtoList.length; i++) {
            inputRepository.save(dtoList[i].toEntity());
        }
    }

    @Override
    public InputFindResponse findInputBySidoCode(Long sidoCode) {
        Input result = inputRepository.findById(sidoCode).orElseThrow(InputNotFoundException::new);
        return InputFindResponse.builder()
                .co(String.format("%.2f", result.getCo()))
                .humid(result.getHumid())
                .o3(String.format("%.2f", result.getO3()))
                .pm10(String.format("%.2f", result.getPm10()))
                .rain(result.getRain())
                .temp(result.getTempAvg())
                .build();
    }
}
