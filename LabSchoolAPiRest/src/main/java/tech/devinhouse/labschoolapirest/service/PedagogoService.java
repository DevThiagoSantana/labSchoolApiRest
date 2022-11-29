package tech.devinhouse.labschoolapirest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.labschoolapirest.exception.RegistroExistenteException;
import tech.devinhouse.labschoolapirest.exception.RegistroNaoEncontradoException;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.repository.PedagogoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedagogoService {
    private PedagogoRepository repo;
    public List<Pedagogo> consultar() {
        List<Pedagogo>lista =repo.findAll();
        return lista;
    }
    public Pedagogo consultar(Integer id){
        Optional<Pedagogo>pedagogoOpt = repo.findById(id);
        if (pedagogoOpt.isEmpty())
            throw new RegistroNaoEncontradoException("Aluno",id);
        Pedagogo pedagogo= pedagogoOpt.get();
        return pedagogo;

    }

    public Pedagogo salvar(Pedagogo pedagogo){
        Optional<Pedagogo> pedagogoOpt = repo.findByCpf(pedagogo.getCpf());
        if (pedagogoOpt.isPresent())
            throw new RegistroExistenteException("Pedagogo",pedagogo.getCpf());
        pedagogo= repo.save(pedagogo);
        return pedagogo;
    }

}
