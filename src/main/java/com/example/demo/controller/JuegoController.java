package com.example.demo.controller;

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
import com.example.demo.service.JuegoServiceImpl;

@RestController
@RequestMapping("/api")
public class JuegoController {
	@Autowired
	JuegoServiceImpl juegoServiceImpl;
	
	@GetMapping("/juegos")
	public List<Juego> listarJuegos(){
		return juegoServiceImpl.listarJuegos();
	}
	
	@PostMapping("/juegos")
	public Juego salvarJuego(@RequestBody Juego juego) {
		
		return juegoServiceImpl.guardarJuego(juego);
	}
	
	@GetMapping("/juegos/{codigo}")
	public Juego juegoXName(@PathVariable(name="codigo") String name) {
		
		Juego juego_xid= new Juego();
		
		juego_xid=juegoServiceImpl.juegoXID(name);
		
		
		return juego_xid;
	}

	
	
	
	@DeleteMapping("/juegos/{codigo}")
	public void eliminarJuego(@PathVariable(name="codigo")String codigo) {
		juegoServiceImpl.eliminarJuego(codigo);
	}
}
