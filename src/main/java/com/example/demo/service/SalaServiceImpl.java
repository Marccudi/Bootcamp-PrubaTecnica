package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISalaDAO;
import com.example.demo.dto.Sala;

@Service
public class SalaServiceImpl {
	@Autowired
	ISalaDAO salaDAO;

	
	public List<Sala> listarSalas() {

		return salaDAO.findAll();
	}

	
	public Sala guardarSala(Sala sala) {

		return salaDAO.save(sala);
	}

	
	public Sala salaXID(int id) {

		return salaDAO.findById(id).get();
	}

	
	public Sala actualizarSala(Sala sala) {

		return salaDAO.save(sala);
	}

	
	public void eliminarSala(int id) {

		salaDAO.deleteById(id);

	}

}
