package unq.eis.unquiflix.service;

public class UsuarioInexistenteException extends RuntimeException {
    public UsuarioInexistenteException(String loginName) {
        super("Inexistente usuario con login: " + loginName);
    }
}
