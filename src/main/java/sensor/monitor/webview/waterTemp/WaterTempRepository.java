package sensor.monitor.webview.waterTemp;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sensor.monitor.webview.ph.Ph;

import java.util.List;

public interface WaterTempRepository extends JpaRepository<WaterTemp, Integer> {
    @Query("SELECT dp FROM WaterTemp dp ORDER BY dp.date DESC")
    List<WaterTemp> findLatestWaterTempDataPoints(Pageable pageable);
}
