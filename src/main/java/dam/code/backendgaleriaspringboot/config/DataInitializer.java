package dam.code.backendgaleriaspringboot.config;

import dam.code.backendgaleriaspringboot.model.FuentePoder;
import dam.code.backendgaleriaspringboot.repository.FuentePoderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(FuentePoderRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new FuentePoder(null, "Marcial"));
                repository.save(new FuentePoder(null, "Arcana"));
                repository.save(new FuentePoder(null, "Divina"));
                repository.save(new FuentePoder(null, "Primordial"));
                System.out.println("Cargadas fuentes de poder iniciales");
            }
        };
    }
}
