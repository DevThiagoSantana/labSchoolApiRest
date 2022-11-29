package tech.devinhouse.labschoolapirest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PedagogoResponse {
    private Integer codigo;

    private String nome;

    private String telefone;

    private LocalDate dataDeNascimento;

    private Long cpf;

    private int atendimentoPedagogo;
}
