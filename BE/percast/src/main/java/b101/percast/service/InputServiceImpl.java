package b101.percast.service;

import b101.percast.api.ApiExplorer;
import b101.percast.dto.input.InputSaveRequest;
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

    @Scheduled(cron = "0 45 * * * ?")
    @Transactional
    @Override
    public void saveInputData() throws IOException {
        InputSaveRequest[] dtoList = ApiExplorer.getDtoList();
        for(int i = 0; i < dtoList.length; i++) {
            inputRepository.save(dtoList[i].toEntity());
        }
    }
}
