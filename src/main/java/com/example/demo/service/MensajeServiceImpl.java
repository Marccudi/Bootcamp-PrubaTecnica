package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMensajeDAO;
import com.example.demo.dto.Mensaje;

@Service
public class MensajeServiceImpl {
	@Autowired
	IMensajeDAO mensajeDAO;

	
	public List<Mensaje> listarMensajes() {

		return mensajeDAO.findAll();
	}

	
	public Mensaje guardarMensaje(Mensaje mensaje) {

		return mensajeDAO.save(mensaje);
	}

	
	public Mensaje mensajeXID(int id) {

		return mensajeDAO.findById(id).get();
	}

	
	public Mensaje actualizarMensaje(Mensaje mensaje) {

		return mensajeDAO.save(mensaje);
	}

	
	public void eliminarMensaje(int id) {

		mensajeDAO.deleteById(id);

	}

}
