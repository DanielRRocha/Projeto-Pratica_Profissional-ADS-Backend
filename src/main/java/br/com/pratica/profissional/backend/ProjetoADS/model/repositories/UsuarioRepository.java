package br.com.pratica.profissional.backend.ProjetoADS.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.pratica.profissional.backend.ProjetoADS.model.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
