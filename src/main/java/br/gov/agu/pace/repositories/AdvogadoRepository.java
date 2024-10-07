package br.gov.agu.pace.repositories;

import br.gov.agu.pace.entity.AdvogadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvogadoRepository extends JpaRepository<AdvogadoEntity, Long> {
}
