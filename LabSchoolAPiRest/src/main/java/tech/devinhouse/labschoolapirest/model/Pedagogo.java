package tech.devinhouse.labschoolapirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "PEDAGOGO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa{

    private int atendimentoPedagogo;

    public Pedagogo(Integer codigo, String nome, String telefone, LocalDate dataDeNascimento, Long cpf){
        super(codigo, nome, telefone, dataDeNascimento, cpf);
        this.atendimentoPedagogo=0;

    }
}
