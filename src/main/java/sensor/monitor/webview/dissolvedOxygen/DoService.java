package sensor.monitor.webview.dissolvedOxygen;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;import sensor.monitor.webview.ph.Ph;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoService {
    private final DoRepository doRepository;

    public List<Do> getDo() {
        return doRepository.findLatestDoDataPoints(PageRequest.of(0, 10));
    }
}
