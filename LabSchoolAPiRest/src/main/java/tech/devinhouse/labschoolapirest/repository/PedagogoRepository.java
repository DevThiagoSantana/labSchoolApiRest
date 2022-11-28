package tech.devinhouse.labschoolapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.labschoolapirest.model.Pedagogo;

public interface PedagogoRepository extends JpaRepository<Pedagogo,Integer> {
}
