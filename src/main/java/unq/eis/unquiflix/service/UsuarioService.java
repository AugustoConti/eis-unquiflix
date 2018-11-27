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
       usuarioRepository.save(new Usuario("quique", "Enrique Alonso", true));
        usuarioRepository.save(new Usuario("augusto", "Augusto Conti", false));
        usuarioRepository.save(new Usuario("facu", "Facundo ", true));
        usuarioRepository.save(new Usuario("tincho", "Martin Kopececk", false));
        usuarioRepository.save(new Usuario("octa", "Octavio", true));
    }

    private Usuario getUser(String loginName) {
            return usuarioRepository.findByLoginName(loginName).orElseThrow(() -> new UsuarioInexistenteException(loginName));

    }

    @GetMapping(value = "/loginName/{loginName}")
    public Usuario getUsuario(@PathVariable String loginName) {
        return getUser(loginName);
    }

}
