package unq.eis.unquiflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import unq.eis.unquiflix.model.Usuario;
import unq.eis.unquiflix.repository.UsuarioRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        usuarioRepository.save(new Usuario("quique", "Enrique Alonso", true,"123"));
        usuarioRepository.save(new Usuario("augusto", "Augusto Conti", false,"456"));
        usuarioRepository.save(new Usuario("facu", "Facundo Vigo", true,"123"));
        usuarioRepository.save(new Usuario("tincho", "Martin Kopececk", false,"456"));
        usuarioRepository.save(new Usuario("octa", "Octavio Gonzalez", true,"111"));
    }

    private Usuario getUser(String loginName, String pass) {
        return usuarioRepository.findByLoginNameAndPassword(loginName, pass).orElseThrow(() -> new UsuarioIncorrectoException(loginName));

    }

    @PostMapping(value = "auth")
    public Usuario getUsuario(@RequestBody UsuarioSimple usuario) {
        System.out.println(usuario.getUsuario());
        return getUser(usuario.getUsuario(), usuario.getPassword());
    }

}
