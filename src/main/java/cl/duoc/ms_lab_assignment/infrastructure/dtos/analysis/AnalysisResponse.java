package cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis;

import cl.duoc.ms_lab_assignment.domain.entities.AnalysisEntity;

public record AnalysisResponse(
        Long id,
        String name,
        String description

) {
    public static AnalysisResponse fromEntity (AnalysisEntity entity){
        return new AnalysisResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}
