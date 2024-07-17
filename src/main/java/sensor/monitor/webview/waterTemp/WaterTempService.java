package sensor.monitor.webview.waterTemp;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sensor.monitor.webview.ph.Ph;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WaterTempService {
    private final WaterTempRepository waterTempRepository;

    public List<WaterTemp> getWaterTemp() {
        return waterTempRepository.findLatestWaterTempDataPoints(PageRequest.of(0, 10));
    }
}
