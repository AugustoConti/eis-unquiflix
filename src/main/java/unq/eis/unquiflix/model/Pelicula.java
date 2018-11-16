package unq.eis.unquiflix.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ArrayList<Integer> puntuacion= new ArrayList<Integer>();

    protected Pelicula() {
    }

    public Pelicula(String titulo, Categoria categoria, LocalDate estreno, String descripcion, String directores,
                    String actores, String link, String linkPortada) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.estreno = estreno;
        this.descripcion = descripcion;
        this.directores = directores;
        this.actores = actores;
        this.link = link;
        this.linkPortada = linkPortada;
        this.activa = true;

        //se removera cuando el usuario final pueda poner puntuacion
        this.puntuacion.add(1);
        this.puntuacion.add(2);
        this.puntuacion.add(3);
        this.puntuacion.add(5);
        this.puntuacion.add(5);

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
        activa = value;
    }

    public Double getPuntuacion() { return (Double) (puntuacion.stream().mapToDouble(i -> i).sum()) / puntuacion.size();}
}
