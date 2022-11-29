package tech.devinhouse.labschoolapirest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ALUNOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Pessoa{



    @Enumerated(EnumType.STRING)
    private SituacaoDaMatricula situacao;

    private Float nota;

    private int atendimentoAluno;

    public Aluno(Integer codigo, String nome, String telefone, LocalDate dataDeNascimento, Long cpf,SituacaoDaMatricula situacao,Float nota) {
        super(codigo, nome, telefone, dataDeNascimento, cpf);
        this.situacao=situacao;
        this.nota=nota;
        this.atendimentoAluno=0;
    }
}
