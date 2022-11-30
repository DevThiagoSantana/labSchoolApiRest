package tech.devinhouse.labschoolapirest.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.labschoolapirest.dto.AlunoResponse;
import tech.devinhouse.labschoolapirest.dto.AtendimentoRequest;
import tech.devinhouse.labschoolapirest.dto.AtendimentoResponse;
import tech.devinhouse.labschoolapirest.dto.PedagogoResponse;
import tech.devinhouse.labschoolapirest.model.Aluno;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.service.AlunoService;
import tech.devinhouse.labschoolapirest.service.AtendimentoService;
import tech.devinhouse.labschoolapirest.service.PedagogoService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoController {
    private ModelMapper mapper;

    private AtendimentoService service;

    private AlunoService alunoService;

    private PedagogoService pedagogoService;



    @PutMapping()
    public ResponseEntity<AtendimentoResponse> atualizar(@RequestBody @Valid AtendimentoRequest request) {
      service.atendimento(request.getCodigoAluno(), request.getCodigoPedagogo());
      Aluno alunoAt =alunoService.consultar(request.getCodigoAluno());
      Pedagogo pedagogoAT= pedagogoService.consultar(request.getCodigoPedagogo());
      AlunoResponse respAluno = mapper.map(alunoAt, AlunoResponse.class);
      PedagogoResponse respPedagogo = mapper.map(pedagogoAT, PedagogoResponse.class);
        AtendimentoResponse atendimentoResponse = new AtendimentoResponse(respAluno, respPedagogo);
        return ResponseEntity.ok(atendimentoResponse);
    }

}
