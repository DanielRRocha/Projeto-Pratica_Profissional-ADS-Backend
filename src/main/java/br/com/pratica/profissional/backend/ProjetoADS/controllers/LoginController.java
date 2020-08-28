package br.com.pratica.profissional.backend.ProjetoADS.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pratica.profissional.backend.ProjetoADS.model.entities.Usuario;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
//	private UsuarioRepository usuarioRepository;
	private UsuarioController usuario;
	
	private static Logger logger = LogManager.getLogger(UsuarioController.class);
	
	
	@GetMapping("/auth")
	public @ResponseBody int login(@RequestParam(name = "username") String username, @RequestParam(name = "senha") String senha) {
		
		Usuario usuarios = usuario.obterUsuarioUsername(username);
		
		if(usuarios == null) {
			logger.error("Usuario invalido");
			return 0;
		}else if(usuarios.getSenha().equals(senha)) {
			return usuarios.getUsuario_id();
		} else {
			logger.error("Senha invalida");
			logger.warn("usuario: " + usuarios.getUsername() + " errou a senha");
			return 0;
		}
	}
}
