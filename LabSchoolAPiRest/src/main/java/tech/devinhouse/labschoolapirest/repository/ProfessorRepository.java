package tech.devinhouse.labschoolapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapirest.model.Professor;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor,Integer>{
    Optional<Professor> findByCpf(Long cpf);
}
