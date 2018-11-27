package unq.eis.unquiflix.model;

import javax.persistence.*;

@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String loginName;

    private Boolean esAdmin=false;
    private String fullName;


    protected Usuario() {
    }
    public Usuario(String loginName, String fullName, Boolean esAdmin){
        this.esAdmin=esAdmin;
        this.fullName = fullName;
        this.loginName=loginName;
    }

    public Boolean getEsAdmin(){
        return esAdmin;
    }
    public String getNombre() {return fullName;}

}
