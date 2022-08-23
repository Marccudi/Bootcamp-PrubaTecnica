package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensajes")
public class Mensaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String mensaje;
	@Column
	private String fecha;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "sala")
	private Sala sala;

	public Mensaje() {
	}
	public Mensaje(int id, String mensaje, String fecha, Usuario usuario, Sala sala) {
		this.id = id;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.usuario = usuario;
		this.sala = sala;
	}
	public int getId() {
		return id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String getFecha() {
		return fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Sala getSala() {
		return sala;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", mensaje=" + mensaje + ", fecha=" + fecha + ", usuario=" + usuario + ", sala="
				+ sala + "]";
	}

}
