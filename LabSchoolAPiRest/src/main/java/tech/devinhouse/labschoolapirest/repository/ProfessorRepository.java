package tech.devinhouse.labschoolapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapirest.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Integer>{
}
