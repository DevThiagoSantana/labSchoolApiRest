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


    @Column(name = "SITUACAO",nullable = false)
    @Enumerated(EnumType.STRING)
    private SituacaoDaMatricula situacao;

    private Float nota;

    private int atendimentoAluno;

    public Aluno(Integer codigo, String nome, String telefone, LocalDate dataDeNascimento, Long cpf,Float nota,SituacaoDaMatricula situacao) {
        super(codigo, nome, telefone, dataDeNascimento, cpf);
        this.nota=nota;
        this.situacao=situacao;
        this.atendimentoAluno=0;
    }
}
