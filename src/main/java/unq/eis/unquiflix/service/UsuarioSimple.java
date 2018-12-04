package unq.eis.unquiflix.service;

public class UsuarioSimple {
    private String usuario;
    private String password;

    public UsuarioSimple(){}

    public UsuarioSimple(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}
