package tech.devinhouse.labschoolapirest.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class Professor extends Pessoa{

    @ElementCollection(targetClass = EstadoProfessor.class)
    @Column(name = "ESTADO",nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoProfessor estado;

    @ElementCollection(targetClass = ExperienciaProfessor.class)
    @Column(name = "EXPERIENCIA",nullable = false)
    @Enumerated(EnumType.STRING)
    private ExperienciaProfessor experiencia;

    @ElementCollection(targetClass = FormacaoProfessor.class)
    @Column(name = "FORMACAO",nullable = false)
    @Enumerated(EnumType.STRING)
    private FormacaoProfessor formacao;


}
