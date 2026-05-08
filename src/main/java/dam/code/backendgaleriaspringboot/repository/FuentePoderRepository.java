package dam.code.backendgaleriaspringboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import dam.code.backendgaleriaspringboot.model.FuentePoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuentePoderRepository extends JpaRepository<FuentePoder, Long> {
    Optional<FuentePoder> findByNombre(String nombre);
}
