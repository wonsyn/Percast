package b101.percast.service;

import b101.percast.dto.output.OutputFindAllResponseDto;
import b101.percast.repository.OutputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OutputServiceImpl implements OutputService{

    private final OutputRepository outputRepository;

    @Override
    public List<OutputFindAllResponseDto> findAll() {
        return outputRepository.findAll().stream().map(OutputFindAllResponseDto::new)
                .collect(Collectors.toList());
    }
}
