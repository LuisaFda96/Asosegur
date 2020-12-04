package org.gpi.asosegur.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 50)
	private String apellido;
	
	@Column(name = "correo_electronico",unique = true, nullable = false, length = 50)
	private String correoElectronico;
	
	@Column(name = "contraseña", nullable = false, length = 64)
	private String contraseña;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(
				name= "users_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name= "roles_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	public User() {
		
	}


	public User( String nombre, String apellido, String correoElectronico, String contraseña,
			Collection<Role> roles) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.contraseña = contraseña;
		this.roles = roles;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", apellido=" + apellido + ", correoElectronico=" + correoElectronico
				+ ", contraseña=" + contraseña + ", roles=" + roles + "]";
	}


	
	
	
	
}
