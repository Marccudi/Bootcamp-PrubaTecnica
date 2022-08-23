package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Usuario;
import com.example.demo.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@PostMapping("/usuarios")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	
	@GetMapping("/usuarios/{codigo}")
	public Usuario usuarioXID(@PathVariable(name="codigo") int codigo) {
		
		Usuario usuario_xid= new Usuario();
		
		usuario_xid=usuarioServiceImpl.usuarioXID(codigo);
		
		
		return usuario_xid;
	}
	
	@PutMapping("/usuarios/{codigo}")
	public Usuario actualizarUsuario(@PathVariable(name="codigo")int codigo,@RequestBody Usuario usuario) {
		
		Usuario usuario_seleccionado= new Usuario();
		Usuario usuario_actualizado= new Usuario();
		
		usuario_seleccionado= usuarioServiceImpl.usuarioXID(codigo);
		
		usuario_seleccionado.setSteamUser(usuario.getSteamUser());
		
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);
		
		
		return usuario_actualizado;
	}
	
	@DeleteMapping("/usuarios/{codigo}")
	public void eleiminarUsuario(@PathVariable(name="codigo")int codigo) {
		usuarioServiceImpl.eliminarUsuario(codigo);
	}
}
