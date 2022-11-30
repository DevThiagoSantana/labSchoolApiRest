package tech.devinhouse.labschoolapirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PROFESSOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Pessoa{

    @Enumerated(EnumType.STRING)
    private EstadoProfessor estado;

    @Enumerated(EnumType.STRING)
    private ExperienciaProfessor experiencia;

    @Enumerated(EnumType.STRING)
    private FormacaoProfessor formacao;

    public Professor(Integer codigo, String nome, String telefone, LocalDate dataDeNascimento, Long cpf, EstadoProfessor estado,ExperienciaProfessor experiencia,FormacaoProfessor formacao) {
        super(codigo, nome, telefone, dataDeNascimento, cpf);
        this.estado=estado;
        this.experiencia=experiencia;
        this.formacao=formacao;
    }


}
