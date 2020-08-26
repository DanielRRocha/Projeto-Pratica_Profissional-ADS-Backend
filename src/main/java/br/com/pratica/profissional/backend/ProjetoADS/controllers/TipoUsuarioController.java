package br.com.pratica.profissional.backend.ProjetoADS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pratica.profissional.backend.ProjetoADS.model.entities.TipoUsuario;
import br.com.pratica.profissional.backend.ProjetoADS.model.repositories.TipoUsuarioRepository;

@RestController
@RequestMapping(path = "/api/tipousuario")
public class TipoUsuarioController {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	@PostMapping
	public @ResponseBody TipoUsuario novoTipoUsuario(@RequestParam String tipo) {
		
		TipoUsuario tipoUsuario = new TipoUsuario(tipo);
		tipoUsuarioRepository.save(tipoUsuario);
		return tipoUsuario;
		
	}
	
	@GetMapping
	public @ResponseBody Iterable<TipoUsuario> obterTipoUsuario() {
		
		Iterable<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findAll();
		
		return tipoUsuario;
	}

	@GetMapping("/porid")
	public @ResponseBody TipoUsuario obterTipoUsuarioId(@RequestParam(name = "id") int id) {
		
		Iterable<TipoUsuario> tipoUsuario = obterTipoUsuario();
		
		for(TipoUsuario usuario: tipoUsuario) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}
}