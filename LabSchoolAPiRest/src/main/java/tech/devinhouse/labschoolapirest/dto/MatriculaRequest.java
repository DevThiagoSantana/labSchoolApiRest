package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;
import tech.devinhouse.labschoolapirest.model.SituacaoDaMatricula;
import tech.devinhouse.labschoolapirest.validator.ValorDeEnum;

import javax.validation.constraints.NotEmpty;

@Data
public class MatriculaRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    @ValorDeEnum(enumClass = SituacaoDaMatricula.class,message = "{campo.invalido}")
    private String situacao;
}
