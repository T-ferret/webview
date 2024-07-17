package sensor.monitor.webview;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sensor.monitor.webview.dissolvedOxygen.Do;
import sensor.monitor.webview.dissolvedOxygen.DoService;
import sensor.monitor.webview.ph.Ph;
import sensor.monitor.webview.ph.PhService;
import sensor.monitor.webview.waterTemp.WaterTemp;
import sensor.monitor.webview.waterTemp.WaterTempService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ApiController {
    private final DoService doService;
    private final PhService phService;
    private final WaterTempService waterTempService;

    @GetMapping("/api/data/ph")
    public List<Ph> dataPh(Model model) {
        return phService.getPh();
    }

    @GetMapping("/api/data/do")
    public List<Do> dataDo(Model model) { return doService.getDo(); }

    @GetMapping("/api/data/waterTemp")
    public List<WaterTemp> dataWaterTemp(Model model) { return waterTempService.getWaterTemp(); }
}
