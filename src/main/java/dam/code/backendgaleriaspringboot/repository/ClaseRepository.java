package dam.code.backendgaleriaspringboot.repository;

import dam.code.backendgaleriaspringboot.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    void deleteByNombre(String nombre);
    Optional<Clase> findByNombre(String nombre);
}
