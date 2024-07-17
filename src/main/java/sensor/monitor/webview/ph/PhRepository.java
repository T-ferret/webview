package sensor.monitor.webview.ph;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PhRepository extends JpaRepository<Ph, Integer> {
    @Query("SELECT dp FROM Ph dp ORDER BY dp.date DESC")
    List<Ph> findLatestPhDataPoints(Pageable pageable);
}
