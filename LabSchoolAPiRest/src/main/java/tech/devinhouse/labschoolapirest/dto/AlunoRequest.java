package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;
import tech.devinhouse.labschoolapirest.model.SituacaoDaMatricula;
import tech.devinhouse.labschoolapirest.validator.ValorDeEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AlunoRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=8, max=15, message = "{campo.invalido}")
    private String telefone;

    @NotNull(message = "{campo.obrigatorio}")
    private LocalDate dataDeNascimento;

    @NotNull(message = "{campo.obrigatorio}")
    private Long cpf;

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorDeEnum(enumClass = SituacaoDaMatricula.class,message = "{campo.invalido}")
    private String situacao;

    @NotNull(message = "{campo.obrigatorio}")
    private Float nota;
}
