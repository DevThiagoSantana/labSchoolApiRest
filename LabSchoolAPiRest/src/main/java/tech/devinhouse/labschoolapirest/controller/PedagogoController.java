package tech.devinhouse.labschoolapirest.controller;



import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.labschoolapirest.dto.AlunoRequest;
import tech.devinhouse.labschoolapirest.dto.PedagogoResponse;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.service.PedagogoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pedagogo")
@AllArgsConstructor
public class PedagogoController {

    private ModelMapper mapper;

    private PedagogoService service;



    @GetMapping
    public ResponseEntity<List<PedagogoResponse>>listar(){
        List<Pedagogo>pedagogos = service.consultar();
        List<PedagogoResponse>resp = new ArrayList<>();
        for (Pedagogo aluno:pedagogos) {
            PedagogoResponse pedagogoResp = mapper.map(aluno, PedagogoResponse.class);
            resp.add(pedagogoResp);
        }
        return  ResponseEntity.ok(resp);
    }
    @GetMapping("{codigo}")
    public ResponseEntity<PedagogoResponse> consultarPeloId(@PathVariable("codigo") Integer codigo) {
        Pedagogo pedagogo = service.consultar(codigo);
        PedagogoResponse resp = mapper.map(pedagogo, PedagogoResponse.class);
        return ResponseEntity.ok(resp);
    }

}
