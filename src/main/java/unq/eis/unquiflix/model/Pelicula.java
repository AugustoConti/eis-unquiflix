package unq.eis.unquiflix.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private String descripcion;
    private String directores;
    private String actores;
    private String link;
    private String linkPortada;
    private Boolean activa;

    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    private List<Integer> puntuacion;

    protected Pelicula() {
    }

    public Pelicula(String titulo, Categoria categoria, LocalDate estreno, String descripcion, String directores,
                    String actores, String link, String linkPortada, List<Integer> puntuacion) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.estreno = estreno;
        this.descripcion = descripcion;
        this.directores = directores;
        this.actores = actores;
        this.link = link;
        this.linkPortada = linkPortada;
        this.activa = true;
        this.puntuacion = puntuacion;
    }

    public Integer getID() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public String getDescripcion() {
        return descripcion;
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

    public void setActiva(Boolean value) {
        this.activa = value;
    }

    public List<Integer> getPuntuacion() {
        return puntuacion;
    }

    public void addPuntaje(Integer puntaje) {
        this.puntuacion.add(puntaje);
    }

    @JsonIgnore
    public Double getRanking() {
        return puntuacion.stream().mapToInt(i -> i).average().orElse(0);
    }
}
