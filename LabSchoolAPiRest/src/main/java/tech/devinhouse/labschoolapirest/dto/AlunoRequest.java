package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;
import tech.devinhouse.labschoolapirest.model.SituacaoDaMatricula;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AlunoRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=8, max=11, message = "{campo.invalido}")
    private String telefone;

    @NotEmpty(message = "{campo.obrigatorio}")
    private LocalDate dataDeNascimento;

    @NotEmpty(message = "{campo.obrigatorio}")
    private Long cpf;

    @NotEmpty(message = "{campo.obrigatorio}")
    private SituacaoDaMatricula situacao;

    @NotEmpty(message = "{campo.obrigatorio}")
    private Float nota;
}
