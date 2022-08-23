package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="salas")
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	
	
	@ManyToOne
	@JoinColumn(name = "juego")
	private Juego juego;
	
	@OneToMany
	@JoinColumn(name = "mensaje")
	private List<Mensaje> mensaje;
	
	public Sala() {
	}
	
	public Sala(int id, String nombre, Juego juego, List<Mensaje> mensaje) {
		this.id = id;
		this.nombre = nombre;
		this.juego = juego;
		this.mensaje = mensaje;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}



	public Juego getJuego() {
		return juego;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public List<Mensaje> getMensaje() {
		return mensaje;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", juego=" + juego + ", mensaje="
				+ mensaje + "]";
	}
	

	

}
