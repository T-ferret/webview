package sensor.monitor.webview;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sensor.monitor.webview.dissolvedOxygen.Do;
import sensor.monitor.webview.dissolvedOxygen.DoService;
import sensor.monitor.webview.ph.PhService;
import sensor.monitor.webview.waterTemp.WaterTempService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final PhService phService;
    private final DoService doService;
    private final WaterTempService waterTempService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/do")
    public String Do(Model model) {
        return "do_monitor";
    }

    @GetMapping("/waterTemp")
    public String waterTemp() {
        return "waterTemp_monitor";
    }

    @GetMapping("/ph")
    public String Ph() {
        return "ph_monitor";
    }
}
