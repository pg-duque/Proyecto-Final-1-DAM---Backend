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
                claseRepo.save(new Clase("Guerrero",
                        "Experto en combate cuerpo a cuerpo.",
                        "El guerrero es un especialista absoluto en el manejo de armas y armaduras. Capaz de resistir grandes castigos en primera línea y dominar tácticas militares." +
                                "\n\nCaracterísticas principales:\n• Dado de Golpe: d10.\n• Habilidad clave: Impulso por Acción y Recuperar Aliento.",
                        "https://pixabay.com/es/images/download/dgsstudios-female-9195685_1920.jpg",
                        marcial));
                claseRepo.save(new Clase("Mago",
                        "Manipulador de las energías místicas.",
                        "Un erudito que moldea la realidad mediante el estudio concienzudo de las leyes de la magia. Su grimorio es su posesión más valiosa, permitiéndole lanzar hechizos devastadores." +
                                "\n\nCaracterísticas principales:\n• Dado de Golpe: d6.\n• Habilidad clave: Recuperación Arcana y Lanzamiento de Conjuros.",
                        "https://pixabay.com/es/images/download/dgsstudios-ai-generated-9521762_1920.jpg",
                        arcana));
                claseRepo.save(new Clase("Clérigo",
                        "Canalizador del poder de las deidades.",
                        "Un intermediario entre los mortales y los dioses, que utiliza la fe como un escudo y un arma. Combina magia de curación y soporte con la capacidad de portar armaduras pesadas." +
                                "\n\nCaracterísticas principales:\n• Dado de Golpe: d8.\n• Habilidad clave: Canalizar Divinidad y Expulsar Muertos Vivientes.",
                        "https://pixabay.com/es/images/download/ang3law-priestess-7884359_1920.jpg",
                        divina));
                claseRepo.save(new Clase("Druida",
                        "Guardián de la naturaleza elemental.",
                        "Un místico que extrae su poder de los espíritus de la naturaleza y los elementos. Es capaz de adoptar formas animales salvajes para combatir, explorar o proteger el equilibrio del mundo." +
                                "\n\nCaracterísticas principales:\n• Dado de Golpe: d8.\n• Habilidad clave: Forma Salvaje y Conjuros de la Naturaleza.",
                        "https://pixabay.com/es/images/download/quirkjunkjournals-man-8182047_1920.png",
                        primordial));

                System.out.println(">> Las 4 clases han sido vinculadas e inicializadas con éxito.");
            }
        };
    }
}
