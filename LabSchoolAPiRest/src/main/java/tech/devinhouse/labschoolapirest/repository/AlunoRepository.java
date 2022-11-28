package tech.devinhouse.labschoolapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapirest.model.Aluno;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
    Optional<Aluno> findByCpf(Long cpf);
}

