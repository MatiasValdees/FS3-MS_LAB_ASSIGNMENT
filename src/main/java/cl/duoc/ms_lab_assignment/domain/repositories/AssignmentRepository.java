package cl.duoc.ms_lab_assignment.domain.repositories;

import cl.duoc.ms_lab_assignment.domain.entities.AssignmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<AssignmentEntity,Long> {
}
