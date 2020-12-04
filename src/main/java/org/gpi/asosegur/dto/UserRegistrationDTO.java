package org.gpi.asosegur.dto;

public class UserRegistrationDTO {
	private String nombre;
	private String apellido;
	private String correoElectronico;
	private String contraseña;

	public UserRegistrationDTO(String nombre, String apellido, String correoElectronico, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.contraseña = contraseña;
	}

	public UserRegistrationDTO() {

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

}
