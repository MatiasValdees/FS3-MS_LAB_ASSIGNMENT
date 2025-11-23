package cl.duoc.ms_lab_assignment.domain.repositories;

import cl.duoc.ms_lab_assignment.domain.entities.LaboratoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface LaboratoryRepository extends CrudRepository<LaboratoryEntity,Long> {
}
