package cl.duoc.ms_lab_assignment.infrastructure.rest;

import cl.duoc.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentCreateRequest;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentResponse;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentUpdateRequest;
import cl.duoc.ms_lab_assignment.infrastructure.dtos.wrapper.WrapperResponse;
import cl.duoc.ms_lab_assignment.service.assignment.IAssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
@Slf4j
public class AssignmentRestController {
    private final IAssignmentService service;

    @PostMapping
    public WrapperResponse<AssignmentResponse> create (@Valid @RequestBody AssignmentCreateRequest request){
        log.info("[POST] Solicitud de crear analisis");
        AssignmentResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<AssignmentResponse> updateStatus(@Valid @RequestBody AssignmentUpdateRequest request){
        log.info("[PUT] Solicitud de actualizar asignación a estadoId: {}",request.statusId());
        AssignmentResponse response = service.updateStatus(request);
        return new WrapperResponse<>(response);
    }

    @GetMapping
    public WrapperResponse<List<AssignmentResponse>> readAll (){
        log.info("[GET] Solicitud de obtener todos las asignaciones");
        List<AssignmentResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }

    @GetMapping("/findById/{id}")
    public WrapperResponse<AssignmentResponse> readById (@PathVariable Long id){
        log.info("[GET] Solicitud de obtener asignación por id: {}",id);
        AssignmentResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }

    @DeleteMapping("/deleteById/{id}")
    public WrapperResponse<String> deleteById (@PathVariable Long id){
        log.info("[DELETE] Solicitud de eliminar asignación por id: {}",id);
        service.deleteById(id);
        return new WrapperResponse<>("Eliminado correctamente");
    }

}
