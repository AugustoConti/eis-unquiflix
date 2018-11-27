package unq.eis.unquiflix.repository;

import org.springframework.data.repository.CrudRepository;
import unq.eis.unquiflix.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByLoginName(String loginName);

}
