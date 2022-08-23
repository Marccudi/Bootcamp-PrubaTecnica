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

import com.example.demo.dto.Mensaje;
import com.example.demo.service.MensajeServiceImpl;

@RestController
@RequestMapping("/api")
public class MensajeController {

	@Autowired
	MensajeServiceImpl mensajeServiceImpl;
	
	@GetMapping("/mensajes")
	public List<Mensaje> listarMensajes(){
		return mensajeServiceImpl.listarMensajes();
	}
	
	@PostMapping("/mensajes")
	public Mensaje salvarMensaje(@RequestBody Mensaje mensaje) {
		
		return mensajeServiceImpl.guardarMensaje(mensaje);
	}
	
	@GetMapping("/mensajes/{codigo}")
	public Mensaje mensajeXID(@PathVariable(name="codigo") int codigo) {
		
		Mensaje mensaje_xid= new Mensaje();
		
		mensaje_xid=mensajeServiceImpl.mensajeXID(codigo);
		
		
		return mensaje_xid;
	}
	
	@PutMapping("/mensajes/{codigo}")
	public Mensaje actualizarMensaje(@PathVariable(name="codigo")int codigo,@RequestBody Mensaje mensaje) {
		
		Mensaje mensaje_seleccionado= new Mensaje();
		Mensaje mensaje_actualizado= new Mensaje();
		
		mensaje_seleccionado= mensajeServiceImpl.mensajeXID(codigo);
		
		mensaje_seleccionado.setMensaje(mensaje.getMensaje());
		String hoy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		mensaje_seleccionado.setFecha(hoy);
		mensaje_seleccionado.setMensaje(mensaje.getMensaje());
		mensaje_actualizado = mensajeServiceImpl.actualizarMensaje(mensaje_seleccionado);
		
		
		return mensaje_actualizado;
	}
	
	@DeleteMapping("/mensajes/{codigo}")
	public void eleiminarMensaje(@PathVariable(name="codigo")int codigo) {
		mensajeServiceImpl.eliminarMensaje(codigo);
	}
}
