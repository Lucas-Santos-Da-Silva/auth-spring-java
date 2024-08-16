package br.com.authjwt.configs;

import java.util.ArrayList;
import java.util.List;

import br.com.authjwt.entities.Usuario;
import br.com.authjwt.repositories.UsuarioRepository;

public class UserService {
	private final UsuarioRepository (UsuarioRepository ur = null
	public UserService(UsuárioRepository = ur;
	public List<Usuario> todosUsuarios(){
		List<Usuario lst = new ArrayList <Usuario>();
		usuarioRepository.findAll().forEach(list::findAll)
	}
}
