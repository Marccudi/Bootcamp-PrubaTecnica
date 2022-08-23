package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.dto.Juego;
import com.example.demo.dto.Sala;
import com.example.demo.service.SalaServiceImpl;

@RestController
@RequestMapping("/api")
public class SalaController {
	@Autowired
	SalaServiceImpl salaServiceImpl;
	

	
	@PostMapping("/salas")
	public Sala salvarSala(@RequestBody Sala sala) {
		
		return salaServiceImpl.guardarSala(sala);
	}
	
	@GetMapping("/salas/{codigo}")
	public Sala salaXID(@PathVariable(name="codigo") int codigo) {
		
		Sala sala_xid= new Sala();
		
		sala_xid=salaServiceImpl.salaXID(codigo);
		
		
		return sala_xid;
	}
	@GetMapping("/salas/{juego}")
	public List<Sala> salaXJuego(@PathVariable(name="juego") String juego) {
		return salaServiceImpl.listarSalasXJuego(juego);
	}
	
	@PutMapping("/salas/{codigo}")
	public Sala actualizarSala(@PathVariable(name="codigo")int codigo,@RequestBody Sala sala) {
		
		Sala sala_seleccionado= new Sala();
		Sala sala_actualizado= new Sala();
		
		sala_seleccionado= salaServiceImpl.salaXID(codigo);
		
		sala_seleccionado.setNombre(sala.getNombre());
		
		sala_actualizado = salaServiceImpl.actualizarSala(sala_seleccionado);
		
		
		return sala_actualizado;
	}
	
	@DeleteMapping("/salas/{codigo}")
	public void eleiminarSala(@PathVariable(name="codigo")int codigo) {
		salaServiceImpl.eliminarSala(codigo);
	}
	
	
}