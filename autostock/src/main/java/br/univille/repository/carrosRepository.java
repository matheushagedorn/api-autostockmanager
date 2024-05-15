package br.univille.repository;

import br.univille.model.carros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carrosRepository extends JpaRepository<carros, Long> {
    
}
