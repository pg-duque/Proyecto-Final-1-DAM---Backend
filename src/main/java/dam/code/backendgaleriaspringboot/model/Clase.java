package dam.code.backendgaleriaspringboot.model;

import jakarta.persistence.*;

@Entity // Indica que es una tabla de la base de datos
@Table(name = "clases")

public class Clase {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fuente_poder_id",  nullable = false) // Nombre de la columna FK en la DB
    private FuentePoder fuentePoder;

    public Clase() {

    }

    public Clase(String nombre, String descripcion, FuentePoder fuentePoder) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fuentePoder = fuentePoder;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FuentePoder getFuentePoder() {
        return fuentePoder;
    }

    public void setFuentePoder(FuentePoder fuentePoder) {
        this.fuentePoder = fuentePoder;
    }
}


