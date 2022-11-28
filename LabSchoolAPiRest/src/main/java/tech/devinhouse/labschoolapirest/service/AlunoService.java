package tech.devinhouse.labschoolapirest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapirest.exception.RegistroExistenteException;
import tech.devinhouse.labschoolapirest.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapirest.model.Aluno;
import tech.devinhouse.labschoolapirest.repository.AlunoRepository;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository repo;

    public Aluno salvar(Aluno aluno){
        Optional<Aluno>alunoOpt = repo.findByCpf(aluno.getCpf());
        if (alunoOpt.isPresent())
            throw new RegistroExistenteException("ALuno",aluno.getCpf());
                aluno= repo.save(aluno);
        return aluno;
    }

    public List<Aluno> consultar(){
        return repo.findAll();
    }

    public Aluno consultar(Integer id){
        Optional<Aluno>alunoOpt = repo.findById(id);
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno",id);
        Aluno aluno= alunoOpt.get();
        return aluno;

    }
    public Aluno atualziarMatricula(Aluno alunoAtualizado){
        Optional<Aluno>alunoOpt = repo.findById(alunoAtualizado.getCodigo());
        if (alunoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno", alunoAtualizado.getCodigo());
        Aluno alunoBD = alunoOpt.get();
        alunoBD.setSituacao(alunoAtualizado.getSituacao());
        alunoAtualizado =repo.save(alunoBD);
        return alunoAtualizado;
    }
    public void excluir(Integer codigo){
        boolean existe= repo.existsById(codigo);
        if (!existe)
            throw new RegistroNaoEncontradoException("Aluno",codigo);
        repo.deleteById(codigo);
    }
}
