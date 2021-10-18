package Entidad;

public class ProveedorDTO {
	private int NIT;
	 private String nomcompleto;
	 private String telefono;
	 private String ciudad;
	 private String direccion;
	
	public ProveedorDTO(int NIT, String nomcompleto, String telefono, String ciudad, String direccion) {
		super();
		this.NIT = NIT;
		this.nomcompleto = nomcompleto;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	

public ProveedorDTO(int NIT) {
		this.NIT = NIT;
		
}

	
	public int getNIT() {
		return NIT;
	}
	public void setNIT(int NIT) {
		this.NIT = NIT;
	}
	public String getNomcompleto() {
		return nomcompleto;
	}
	public void setNomcompleto(String nomcompleto) {
		this.nomcompleto = nomcompleto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
