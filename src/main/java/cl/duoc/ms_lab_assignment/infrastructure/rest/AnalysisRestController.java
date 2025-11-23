package cl.duoc.ms_lab_assignment.infrastructure.rest;

import cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisCreateRequest;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisResponse;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisUpdateRequest;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.wrapper.WrapperResponse;
import cl.duoc.ms_lab_assignment.service.analysis.IAnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
@Slf4j
public class AnalysisRestController {
    private final IAnalysisService service;

    @PostMapping
    public WrapperResponse<AnalysisResponse> create (@Valid @RequestBody AnalysisCreateRequest request){
        log.info("[POST] Solicitud de crear analisis");
        AnalysisResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<AnalysisResponse> update (@Valid @RequestBody AnalysisUpdateRequest request){
        log.info("[PUT] Solicitud de actualizar analisis");
        AnalysisResponse response = service.update(request);
        return new WrapperResponse<>(response);
    }

    @GetMapping
    public WrapperResponse<List<AnalysisResponse>> readAll (){
        log.info("[GET] Solicitud de obtener todos los analisis");
        List<AnalysisResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }

    @GetMapping("findById/{id}")
    public WrapperResponse<AnalysisResponse> readById (@PathVariable Long id){
        log.info("[GET] Solicitud de obtener analisis por id: {}",id);
        AnalysisResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }

    @DeleteMapping("deleteById/{id}")
    public WrapperResponse<String> deleteById (@PathVariable Long id){
        log.info("[DELETE] Solicitud de eliminación de analisis por id: {}",id);
         service.deleteById(id);
         String response = "Eliminado correctamente" ;
        return new WrapperResponse<>(response);
    }

}
