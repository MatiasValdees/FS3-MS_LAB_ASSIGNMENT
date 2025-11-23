package cl.duoc.ms_lab_assignment.service.laboratory;

import cl.duoc.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryCreateRequest;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryResponse;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryUpdateRequest;

import java.util.List;

public interface ILaboratoryService {
    List<LaboratoryResponse> findAll();
    LaboratoryResponse findById(Long id);
    LaboratoryResponse create (LaboratoryCreateRequest request);
    LaboratoryResponse update (LaboratoryUpdateRequest request);

    void deleteById(Long id);
}
