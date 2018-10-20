package unq.eis.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String titulo;

    private LocalDate estreno;
    private String directores;
    private String actores;
    private String link;

    protected Pelicula() {
    }

    public Pelicula(String titulo, LocalDate estreno, String directores, String actores, String link) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.directores = directores;
        this.actores = actores;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public String getDirectores() {
        return directores;
    }

    public String getActores() {
        return actores;
    }

    public String getLink() {
        return link;
    }
}
