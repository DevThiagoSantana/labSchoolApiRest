package tech.devinhouse.labschoolapirest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapirest.dto.AlunoRequest;
import tech.devinhouse.labschoolapirest.dto.AlunoResponse;
import tech.devinhouse.labschoolapirest.dto.ErroResponse;
import tech.devinhouse.labschoolapirest.model.Aluno;
import tech.devinhouse.labschoolapirest.service.AlunoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/alunos")
@AllArgsConstructor
public class AlunoController {

    private ModelMapper mapper;

    private AlunoService service;

//    @Operation(summary = "Serviço de Cadastro de Aluno", description = "Insere alunos no servidor para ficar disponível para acesso dos usuários")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso",
//                            content = { @Content(schema = @Schema(implementation = AlunoResponse.class)) }),
//                    @ApiResponse(responseCode = "409", description = "Aluno com CPF já cadastrado",
//                            content = { @Content(schema = @Schema(implementation = ErroResponse.class)) }),
//                    @ApiResponse(responseCode = "400", description = "Requisição com dados inválidos ",
//                            content = { @Content(schema = @Schema(implementation = ErroResponse.class)) }
//                    )
//            }
//    )
    @PostMapping
    public ResponseEntity<AlunoResponse> criar(@RequestBody @Valid AlunoRequest request){
        Aluno aluno= mapper.map(request, Aluno.class);
        aluno =service.salvar(aluno);
        AlunoResponse resp= mapper.map(aluno, AlunoResponse.class);
        return ResponseEntity.created(URI.create(resp.getCodigo().toString())).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>>listar(){
        List<Aluno>alunos = service.consultar();
        List<AlunoResponse>resp = new ArrayList<>();
        for (Aluno aluno:alunos){
            AlunoResponse alunoResp = mapper.map(aluno, AlunoResponse.class);
        }
    }

}