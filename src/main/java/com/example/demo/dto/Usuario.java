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
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column(name="pass")
	private String password;
	@Column(name="steam_user")
	private String steamUser;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Mensaje> mensaje;

	public Usuario() {
	}
	public Usuario(int id, String username, String password, String steamUser, List<Mensaje> mensaje) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.steamUser = steamUser;
		this.mensaje = mensaje;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getSteamUser() {
		return steamUser;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mensaje")
	public List<Mensaje> getMensaje() {
		return mensaje;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSteamUser(String steamUser) {
		this.steamUser = steamUser;
	}
	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", steamUser=" + steamUser
				+ ", mensaje=" + mensaje + "]";
	}

	
}
