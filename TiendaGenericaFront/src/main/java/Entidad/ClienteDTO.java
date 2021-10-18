package Entidad;

public class ClienteDTO {
	private int documento;
	 private String nomcompleto;
	 private String telefono;
	 private String direccion;
	 private String email;
	
	public ClienteDTO(int documento, String nomcompleto, String telefono, String direccion, String email) {
		super();
		this.documento = documento;
		this.nomcompleto = nomcompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
	}
	

public ClienteDTO(int documento) {
		this.documento = documento;
		
}

	
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 


}
