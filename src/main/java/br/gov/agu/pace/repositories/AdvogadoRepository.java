package br.gov.agu.pace.repositories;

import br.gov.agu.pace.entities.AdvogadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvogadoRepository extends JpaRepository<AdvogadoEntity, Long> {
}
