package sensor.monitor.webview.ph;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhService {
    private final PhRepository phRepository;

    public List<Ph> getPh() {
        return phRepository.findLatestPhDataPoints(PageRequest.of(0, 10));
    }
}
