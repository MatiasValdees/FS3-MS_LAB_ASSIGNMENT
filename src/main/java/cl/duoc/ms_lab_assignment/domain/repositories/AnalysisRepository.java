package cl.duoc.ms_lab_assignment.domain.repositories;

import cl.duoc.ms_lab_assignment.domain.entities.AnalysisEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnalysisRepository extends CrudRepository<AnalysisEntity,Long> {
}
