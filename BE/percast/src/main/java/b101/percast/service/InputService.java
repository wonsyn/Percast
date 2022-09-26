package b101.percast.service;

import b101.percast.dto.input.InputFindResponse;

import java.io.IOException;

public interface InputService {
    void saveInputData() throws IOException;
    InputFindResponse findInputBySidoCode(Long sidoCode);
}
