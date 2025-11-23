package cl.duoc.ms_lab_assignment.domain.repositories;

import cl.duoc.ms_lab_assignment.domain.entities.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<StatusEntity,Integer> {
}
