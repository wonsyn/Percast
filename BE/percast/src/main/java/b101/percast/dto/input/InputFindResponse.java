package b101.percast.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InputFindResponse {
    double temp;
    double humid;
    double rain;
    String pm10;
    String co;
    String o3;
}
