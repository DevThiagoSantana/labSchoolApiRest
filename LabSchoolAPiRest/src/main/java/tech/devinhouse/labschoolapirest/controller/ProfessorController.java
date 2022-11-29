package tech.devinhouse.labschoolapirest.controller;



import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapirest.dto.AlunoRequest;
import tech.devinhouse.labschoolapirest.dto.ProfessorResponse;
import tech.devinhouse.labschoolapirest.model.Professor;
import tech.devinhouse.labschoolapirest.service.ProfessorService;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/professor")
@AllArgsConstructor
public class ProfessorController {

    private ModelMapper mapper;

    private ProfessorService service;


    @PostMapping
    public ResponseEntity<ProfessorResponse> criar(@RequestBody @Valid AlunoRequest request){
        Professor professor= mapper.map(request, Professor.class);
        professor =service.salvar(professor);
        ProfessorResponse resp= mapper.map(professor, ProfessorResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>>listar(){
        List<Professor>professores = service.consultar();
        List<ProfessorResponse>resp = new ArrayList<>();
        for (Professor aluno:professores) {
            ProfessorResponse professorResp = mapper.map(aluno, ProfessorResponse.class);
            resp.add(professorResp);
        }
        return  ResponseEntity.ok(resp);
    }
    @GetMapping("{codigo}")
    public ResponseEntity<ProfessorResponse> consultarPeloId(@PathVariable("codigo") Integer codigo) {
        Professor professor = service.consultar(codigo);
        ProfessorResponse resp = mapper.map(professor, ProfessorResponse.class);
        return ResponseEntity.ok(resp);
    }


}
