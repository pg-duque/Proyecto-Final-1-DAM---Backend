package dam.code.backendgaleriaspringboot.repository;

import dam.code.backendgaleriaspringboot.model.FuentePoder;

import java.util.Optional;

public interface FuentePoderRepositiry extends JpaRepository<FuentePoder, Long> {
    Optional<FuentePoder> findByNombre(String nombre);
}
