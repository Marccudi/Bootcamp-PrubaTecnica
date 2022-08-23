package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="juegos")
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Sala> sala;

	public Juego() {
	}
	public Juego(int id, String nombre, List<Sala> sala) {
		this.id = id;
		this.nombre = nombre;
		this.sala = sala;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	public List<Sala> getSala() {
		return sala;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSala(List<Sala> sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Juego [id=" + id + ", nombre=" + nombre + ", sala=" + sala + "]";
	}
	
	
}
