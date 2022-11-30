package tech.devinhouse.labschoolapirest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapirest.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapirest.model.Aluno;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.model.SituacaoDaMatricula;
import tech.devinhouse.labschoolapirest.repository.AlunoRepository;
import tech.devinhouse.labschoolapirest.repository.PedagogoRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AtendimentoService {

    private AlunoRepository alunoRepo;

    private PedagogoRepository pedagogoRepo;

    public void atendimento(Integer codigoAluno,Integer codigoPedagogo){

        Optional<Aluno> alunoOpt = alunoRepo.findById(codigoAluno);
        Optional<Pedagogo>pedagogoOpt = pedagogoRepo.findById(codigoPedagogo);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", codigoAluno);
        if (pedagogoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Pedagogo",codigoPedagogo);
        Aluno alunoBD = alunoOpt.get();
        Pedagogo pedagogoBD = pedagogoOpt.get();
        alunoBD.setSituacao(SituacaoDaMatricula.ATENDIMENTO_PEDAGOGICO);
        alunoBD.setAtendimentoAluno(alunoBD.getAtendimentoAluno()+1);
        pedagogoBD.setAtendimentoPedagogo(pedagogoBD.getAtendimentoPedagogo()+1);
        Aluno alunoAtualizado =alunoRepo.save(alunoBD);
        Pedagogo pedagogoAtualizado = pedagogoRepo.save(pedagogoBD);

    }
}
