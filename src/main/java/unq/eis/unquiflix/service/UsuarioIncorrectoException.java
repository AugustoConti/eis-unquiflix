package unq.eis.unquiflix.service;

public class UsuarioIncorrectoException extends RuntimeException {
    public UsuarioIncorrectoException(String loginName) {
        super("Usuario incorrecto: " + loginName);
    }
}
