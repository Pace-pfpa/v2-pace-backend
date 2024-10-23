package br.gov.agu.pace.repositories;

import br.gov.agu.pace.entity.AdvogadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AdvogadoRepository extends JpaRepository<AdvogadoEntity, Long> {
    
    Optional<AdvogadoEntity> findByNumeroOab(String numeroOab);

    //Verifica se numero da OAB já existe no banco
    boolean existsByNumeroOab(String numeroOab);

    List<AdvogadoEntity> findAdvogadoEntitiesByNomeContaining(String nome);
}

