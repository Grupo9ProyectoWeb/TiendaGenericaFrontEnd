package Entidad;

public class UsuarioDTO {

	 private int documento;
	 private String nomcompleto;
	 private String clave;
	 private String usuario;
	 private String email;
	
	public UsuarioDTO(int documento, String nomcompleto, String clave, String usuario, String email) {
		super();
		this.documento = documento;
		this.nomcompleto = nomcompleto;
		this.clave = clave;
		this.usuario = usuario;
		this.email = email;
	}
	

public UsuarioDTO(int documento) {
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
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 

}
