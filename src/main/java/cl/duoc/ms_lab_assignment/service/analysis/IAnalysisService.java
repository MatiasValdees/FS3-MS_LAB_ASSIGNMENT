package cl.duoc.ms_lab_assignment.service.analysis;

import cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisCreateRequest;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisResponse;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisUpdateRequest;

import java.util.List;

public interface IAnalysisService {
    AnalysisResponse create (AnalysisCreateRequest request);
    AnalysisResponse update (AnalysisUpdateRequest request);
    List<AnalysisResponse> findAll();
    AnalysisResponse findById(Long id);
    void deleteById(Long id);
}
