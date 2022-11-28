package tech.devinhouse.labschoolapirest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import tech.devinhouse.labschoolapirest.model.SituacaoDaMatricula;

import java.time.LocalDate;

@Data
@Schema(title = "AlunoResposta", description = "Representa a resposta da API em relação a um Aluno cadastrado")
public class AlunoResponse {

    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataDeNascimento;

    private Long cpf;

    private SituacaoDaMatricula situacao;

    private Float nota;

    private int atendimentoAluno;

}
