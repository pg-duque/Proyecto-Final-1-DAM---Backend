package dam.code.backendgaleriaspringboot.controller;

import dam.code.backendgaleriaspringboot.model.Clase;
import dam.code.backendgaleriaspringboot.repository.ClaseRepository; // Asegúrate de importar tu repo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clases") // Centralizamos la ruta aquí
@CrossOrigin(origins = "*")
public class ClasesController {

    @Autowired
    private ClaseRepository claseRepository; // Inyectamos el repositorio

    //OBTENER TODAS LAS CLASES
    @GetMapping
    public List<Clase> datosClases() {
        return claseRepository.findAll(); // Busca en Postgres
    }

    // INSERTAR CLASES
    @PostMapping
    public Clase insertarClase(@RequestBody Clase clase) {
        return claseRepository.save(clase); // Guarda en Postgres
    }

    // BORRAR CLASE POR NOMBRE
    @DeleteMapping("/{nombre}")
    @Transactional // Obligatorio para borrar por un campo que no sea ID
    public void borrarClase(@PathVariable String nombre) {
        claseRepository.deleteByNombre(nombre);
    }

    // ACTUALIZAR CLASE POR NOMBRE
    @PutMapping("/{nombre}")
    @Transactional
    public Clase actualizarClase(@RequestBody Clase claseActualizada, @PathVariable String nombre) {
        // Buscamos la clase en la DB, si no existe lanzamos error
        Clase claseExistente = claseRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada: " + nombre));

        claseExistente.setDescripcion(claseActualizada.getDescripcion());
        claseExistente.setDescripcionExtendida(claseActualizada.getDescripcionExtendida());
        claseExistente.setImagenUrl(claseActualizada.getImagenUrl());
        // Al estar en una transacción, se guarda automáticamente al terminar el método

        return claseExistente;
    }
}
