package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IJuegoDAO;
import com.example.demo.dto.Juego;

@Service
public class JuegoServiceImpl{
	@Autowired
	IJuegoDAO juegoDAO;

	
	public List<Juego> listarJuegos() {

		return juegoDAO.findAll();
	}

	
	public Juego guardarJuego(Juego juego) {

		return juegoDAO.save(juego);
	}

	
	public Juego juegoXID(String name) {

		return juegoDAO.findById(name).get();
	}

	
	public Juego actualizarJuego(Juego juego) {

		return juegoDAO.save(juego);
	}

	
	public void eliminarJuego(String id) {

		juegoDAO.deleteById(id);

	}

	

}
