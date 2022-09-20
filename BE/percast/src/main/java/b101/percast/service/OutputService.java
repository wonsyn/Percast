package b101.percast.service;

import b101.percast.dto.output.OutputFindAllResponseDto;

import java.util.List;

public interface OutputService {
    List<OutputFindAllResponseDto> findAll();
}
