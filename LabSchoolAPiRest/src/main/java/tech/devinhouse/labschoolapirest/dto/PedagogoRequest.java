package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PedagogoRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=15, message = "{campo.invalido}")
    private String telefone;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private LocalDate dataDeNascimento;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private Long cpf;
}
