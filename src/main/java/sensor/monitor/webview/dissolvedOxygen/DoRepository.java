package sensor.monitor.webview.dissolvedOxygen;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoRepository extends JpaRepository<Do, Integer> {
    @Query("SELECT dp FROM Do dp ORDER BY dp.date DESC")
    List<Do> findLatestDoDataPoints(Pageable pageable);
}
