package dam.code.backendgaleriaspringboot.repository;

import dam.code.backendgaleriaspringboot.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    void deleteByNombre(String nombre);
    Optional<Clase> findByNombre(String nombre);
}
