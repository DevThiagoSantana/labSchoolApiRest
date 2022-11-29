package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;
import tech.devinhouse.labschoolapirest.model.EstadoProfessor;
import tech.devinhouse.labschoolapirest.model.ExperienciaProfessor;
import tech.devinhouse.labschoolapirest.model.FormacaoProfessor;

import java.time.LocalDate;

@Data
public class ProfessorResponse {
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataDeNascimento;

    private Long cpf;

    private EstadoProfessor estado;

    private ExperienciaProfessor experiencia;

    private FormacaoProfessor formacao;

}
