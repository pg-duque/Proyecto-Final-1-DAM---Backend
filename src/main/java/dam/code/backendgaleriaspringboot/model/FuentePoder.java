package dam.code.backendgaleriaspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fuente_poder")
@Data
@NoArgsConstructor
@Getter
@Setter
public class FuentePoder {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "fuentePoder", cascade = CascadeType.ALL)
    private List<Clase> clases = new ArrayList<>();

    public FuentePoder(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
