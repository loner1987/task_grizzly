package my.task.repository;

import my.task.domain.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Loner on 24.01.2017.
 */
@Transactional
public interface ReportRepository extends JpaRepository<Reports, Long> {
}
