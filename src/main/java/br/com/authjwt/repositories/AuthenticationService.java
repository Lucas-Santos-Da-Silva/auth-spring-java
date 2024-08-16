package br.com.authjwt.repositories;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.authjwt.entities.Usuario;

public class AuthenticationService {
	private UsuarioRepository usuarioRepository;
	private PasswordEncoder senhaEncoder;
	private AuthenticationManager authenticationManager;
}
pubic AuthenticationService(Usuario Repository rud) {
	Usuario us = new Usuario();
	us.setNomeCOmpleto(rud.getNomeCompleto;)us.setEmail());
	us.setEmail(rud.getEmail);
	us.setSenha(senhaenconder(encode(rud.gerSe)))
}