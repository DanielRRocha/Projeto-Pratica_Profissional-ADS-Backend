package br.com.pratica.profissional.backend.ProjetoADS.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pratica.profissional.backend.ProjetoADS.model.entities.Usuario;
import br.com.pratica.profissional.backend.ProjetoADS.model.repositories.UsuarioRepository;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
//	private static Logger logger = LogManager.getLogger(UsuarioController.class);
	
	@PostMapping
	public Usuario novoUsuario(String nome, String sobrenome, String username, String cpf, String email, String senha, int usuario_id) throws SQLIntegrityConstraintViolationException {
		
			Usuario usuario = new Usuario(nome, sobrenome, username, cpf, email, senha, usuario_id);
			usuarioRepository.save(usuario);
			
			return usuario;
	}
	
	@GetMapping
	public @ResponseBody Iterable<Usuario> obterUsuario() {
		
		Iterable<Usuario> tipoUsuario = usuarioRepository.findAll();
		
		return tipoUsuario;
	}

	@GetMapping("/busca/id")
	public @ResponseBody Usuario obterUsuarioId(@RequestParam(name = "id") int id) {
		
		Iterable<Usuario> usuarios = obterUsuario();
		
		for(Usuario usuario: usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

	@GetMapping("/busca/usuarioid")
	public @ResponseBody List<Usuario> obterUsuarioUsuarioId(@RequestParam(name = "usuario_id") int usuario_id) {
		
		Iterable<Usuario> usuarios = obterUsuario();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		for(Usuario usuario: usuarios) {
			if(usuario.getUsuario_id() == usuario_id) {
				listaUsuario.add(usuario);
			}
		}
		return listaUsuario;
	}
	
	@GetMapping("/busca/username")
	public @ResponseBody Usuario obterUsuarioUsername(@RequestParam(name = "username") String username) {
		
		Iterable<Usuario> usuarios = obterUsuario();
		
		for(Usuario usuario: usuarios) {
			if(usuario.getUsername().equals(username)) {
				return usuario;
			}
		}
		return null;
	}
}
