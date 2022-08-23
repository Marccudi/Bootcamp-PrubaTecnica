package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.dto.Usuario;

@Service
public class UsuarioServiceImpl {
	@Autowired
	IUsuarioDAO usuarioDAO;

	
	public List<Usuario> listarUsuarios() {

		return usuarioDAO.findAll();
	}

	
	public Usuario guardarUsuario(Usuario usuario) {

		return usuarioDAO.save(usuario);
	}

	
	public Usuario usuarioXID(int id) {

		return usuarioDAO.findById(id).get();
	}

	
	public Usuario actualizarUsuario(Usuario usuario) {

		return usuarioDAO.save(usuario);
	}

	
	public void eliminarUsuario(int id) {

		usuarioDAO.deleteById(id);

	}

}
