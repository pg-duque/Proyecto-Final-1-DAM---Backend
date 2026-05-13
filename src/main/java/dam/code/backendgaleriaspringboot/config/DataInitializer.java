package dam.code.backendgaleriaspringboot.config;

import dam.code.backendgaleriaspringboot.model.Clase;
import dam.code.backendgaleriaspringboot.model.FuentePoder;
import dam.code.backendgaleriaspringboot.repository.ClaseRepository;
import dam.code.backendgaleriaspringboot.repository.FuentePoderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(FuentePoderRepository fuenteRepo, ClaseRepository claseRepo) {
        return args -> {

            // 1. INICIALIZAR FUENTES DE PODER (Solo si la tabla está vacía)
            if (fuenteRepo.count() == 0) {
                fuenteRepo.save(new FuentePoder(null, "Marcial"));
                fuenteRepo.save(new FuentePoder(null, "Arcana"));
                fuenteRepo.save(new FuentePoder(null, "Divina"));
                fuenteRepo.save(new FuentePoder(null, "Primordial"));
                System.out.println(">> Fuentes de poder creadas desde cero.");
            }

            // 2. INICIALIZAR CLASES (Solo si la tabla de clases está vacía)
            if (claseRepo.count() == 0) {
                // Buscamos las fuentes directamente de la BD para obtener sus IDs reales instalados
                FuentePoder marcial = fuenteRepo.findAll().stream().filter(f -> f.getNombre().equals("Marcial")).findFirst().orElse(null);
                FuentePoder arcana = fuenteRepo.findAll().stream().filter(f -> f.getNombre().equals("Arcana")).findFirst().orElse(null);
                FuentePoder divina = fuenteRepo.findAll().stream().filter(f -> f.getNombre().equals("Divina")).findFirst().orElse(null);
                FuentePoder primordial = fuenteRepo.findAll().stream().filter(f -> f.getNombre().equals("Primordial")).findFirst().orElse(null);

                // Insertamos las clases vinculándolas de forma segura
                claseRepo.save(new Clase("Guerrero", "Experto en combate cuerpo a cuerpo.", marcial));
                claseRepo.save(new Clase("Mago", "Manipulador de las energías místicas.", arcana));
                claseRepo.save(new Clase("Clérigo", "Canalizador del poder de las deidades.", divina));
                claseRepo.save(new Clase("Druida", "Guardián de la naturaleza elemental.", primordial));

                System.out.println(">> Las 4 clases han sido vinculadas e inicializadas con éxito.");
            }
        };
    }
}
