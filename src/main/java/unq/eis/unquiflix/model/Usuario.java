package unq.eis.unquiflix.model;

import unq.eis.unquiflix.service.UsuarioIncorrectoException;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String loginName;

    private Boolean esAdmin;
    private String fullName;
    private String password;


    protected Usuario() {
    }

    public Usuario(String loginName, String fullName, Boolean esAdmin, String password) {
        this.esAdmin = esAdmin;
        this.fullName = fullName;
        this.loginName = loginName;
        this.password = password;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public String getNombre() {
        return fullName;
    }


}
