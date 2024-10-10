package br.gov.agu.pace.repositories;

import br.gov.agu.pace.entity.AudienciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AudienciaRepository extends JpaRepository<AudienciaEntity, Long> {

}
