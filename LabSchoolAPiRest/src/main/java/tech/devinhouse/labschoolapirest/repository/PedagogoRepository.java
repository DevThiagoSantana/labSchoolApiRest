package tech.devinhouse.labschoolapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapirest.model.Pedagogo;

import java.util.Optional;

public interface PedagogoRepository extends JpaRepository<Pedagogo,Integer> {
    Optional<Pedagogo> findByCpf(Long cpf);
}
