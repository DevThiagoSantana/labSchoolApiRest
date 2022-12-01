package tech.devinhouse.labschoolapirest.controller;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapirest.dto.AlunoRequest;
import tech.devinhouse.labschoolapirest.dto.AlunoResponse;
//import tech.devinhouse.labschoolapirest.dto.ErroResponse;
import tech.devinhouse.labschoolapirest.dto.MatriculaRequest;
import tech.devinhouse.labschoolapirest.model.Aluno;
import tech.devinhouse.labschoolapirest.model.SituacaoDaMatricula;
import tech.devinhouse.labschoolapirest.service.AlunoService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {

    private ModelMapper mapper;

    private AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody @Valid AlunoRequest request){
        Aluno aluno= mapper.map(request, Aluno.class);
        aluno =service.salvar(aluno);
        AlunoResponse resp= mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>>listar(@RequestParam(value = "situacao", required = false)
                                                         @Pattern(regexp = "ATIVO|IRREGULAR|ATENDIMENTO_PEDAGOGICO|INATIVO",
                                                                 flags = Pattern.Flag.CASE_INSENSITIVE, message = "{campo.invalido}") String situacao){

        List<Aluno>alunos = service.consultar(situacao);
        List<AlunoResponse>resp = new ArrayList<>();
        for (Aluno aluno:alunos) {
            AlunoResponse alunoResp = mapper.map(aluno, AlunoResponse.class);
            resp.add(alunoResp);
        }
        return  ResponseEntity.ok(resp);
    }
    @GetMapping("{codigo}")
    public ResponseEntity<AlunoResponse> consultarPeloId(@PathVariable("codigo") Integer codigo) {
        Aluno aluno = service.consultar(codigo);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(resp);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable("codigo") Integer codigo, @RequestBody @Valid MatriculaRequest request) {
        Aluno aluno = mapper.map(request, Aluno.class);
        aluno.setCodigo(codigo);
        aluno= service.atualziarMatricula(aluno);
        AlunoResponse resp = mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity excluir(@PathVariable("codigo") Integer codigo) {
        service.excluir(codigo);
        return ResponseEntity.noContent().build();
    }

}
