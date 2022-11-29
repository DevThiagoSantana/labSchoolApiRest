package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;
import tech.devinhouse.labschoolapirest.model.EstadoProfessor;
import tech.devinhouse.labschoolapirest.model.ExperienciaProfessor;
import tech.devinhouse.labschoolapirest.model.FormacaoProfessor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ProfessorRequest {

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=9, max=15, message = "{campo.invalido}")
    private String telefone;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private LocalDate dataDeNascimento;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private Long cpf;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private EstadoProfessor estado;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private ExperienciaProfessor experiencia;

    @NotEmpty(message = "{campo.obrigatorio}")
    @Size(min=3, max=50, message = "{campo.invalido}")
    private FormacaoProfessor formacao;
}
