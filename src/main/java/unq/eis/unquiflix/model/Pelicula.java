package unq.eis.unquiflix.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private LocalDate estreno;
    private String directores;
    private String actores;
    private String link;
    private String linkPortada;
    private Boolean activa;

    protected Pelicula() {
    }

    public Pelicula(String titulo, Categoria categoria, LocalDate estreno, String directores,
                    String actores, String link, String linkPortada) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.estreno = estreno;
        this.directores = directores;
        this.actores = actores;
        this.link = link;
        this.linkPortada = linkPortada;
        this.activa = true;
    }

    public Integer getID(){
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Categoria getCategoria() { return this.categoria; }

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

    public String getLinkPortada() {
        return linkPortada;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void cambiarActivacion() {
        this.activa = !this.activa;
    }
}
