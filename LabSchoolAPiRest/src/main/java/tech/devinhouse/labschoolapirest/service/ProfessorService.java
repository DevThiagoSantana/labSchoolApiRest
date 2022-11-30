package tech.devinhouse.labschoolapirest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapirest.exception.RegistroExistenteException;
import tech.devinhouse.labschoolapirest.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapirest.model.Professor;
import tech.devinhouse.labschoolapirest.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    private ProfessorRepository repo;
    public List<Professor> consultar() {
        List<Professor>lista =repo.findAll();
        return lista;
    }
    public Professor consultar(Integer id){
        Optional<Professor>professorOpt = repo.findById(id);
        if (professorOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno",id);
        Professor professor= professorOpt.get();
        return professor;

    }
    public Professor salvar(Professor professor){
        Optional<Professor> professorOpt = repo.findByCpf(professor.getCpf());
        if (professorOpt.isPresent())
            throw new RegistroExistenteException("Professor",professor.getCpf());
        professor= repo.save(professor);
        return professor;
    }
}
