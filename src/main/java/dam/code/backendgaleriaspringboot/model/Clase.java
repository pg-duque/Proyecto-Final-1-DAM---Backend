package dam.code.backendgaleriaspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que es una tabla de la base de datos
@Table(name = "clases")
@Data
@Getter
@Setter
@NoArgsConstructor

public class Clase {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "descripcion_extendida", columnDefinition = "TEXT")
    private String descripcionExtendida;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fuente_poder_id",  nullable = false) // Nombre de la columna FK en la DB
    @JsonIgnoreProperties("clases")
    private FuentePoder fuentePoder;

    public Clase(String nombre, String descripcion, String descripcionExtendida, FuentePoder fuentePoder) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descripcionExtendida = descripcionExtendida;
        this.fuentePoder = fuentePoder;
    }

}


