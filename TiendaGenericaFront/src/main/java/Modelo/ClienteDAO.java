package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidad.ClienteDTO;
import conexion.Conexion;

public class ClienteDAO {
	Conexion con=new Conexion();
	Connection cnn =con.getConexion();
	PreparedStatement ps;
	ResultSet rs;
	ClienteDTO cli;

	public String insertarcliente(ClienteDTO cl) {
		int x;
		String dat="";
		try {
			cli=consultarcliente(cl);
			if(cli==null) {
				ps=cnn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?)");
				ps.setInt(1, cl.getDocumento());
				ps.setString(2, cl.getNomcompleto());
				ps.setString(3, cl.getTelefono());
				ps.setString(4, cl.getDireccion());
				ps.setString(5, cl.getEmail());
				x=ps.executeUpdate();
					if(x>0) {
						dat="r";
					}
			}	
			else {
				dat="nr";
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar"+e);
			
		}
		
		
		return dat;
	}


	public  ClienteDTO consultarcliente(ClienteDTO cl) {
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM cliente WHERE documento=?");
		ps.setInt(1, cl.getDocumento());
		rs=ps.executeQuery();
		if(rs.next()) {
		   cli=new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return cli;
	}



	public int eliminar(ClienteDTO us) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM cliente WHERE documento=? ");
		ps.setInt(1, us.getDocumento());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(ClienteDTO cl) {
		boolean dat=false;
		JOptionPane.showMessageDialog(null, "dao"+cl.getDocumento());
		JOptionPane.showMessageDialog(null, cl.getNomcompleto());
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE cliente SET nomcompleto=?,telefono=?,direccion=?,email=? WHERE documento=?");
		    ps.setString(1, cl.getNomcompleto());
		    ps.setString(2, cl.getTelefono());
		    ps.setString(3, cl.getDireccion());
		    ps.setString(4, cl.getEmail());
		    ps.setInt(5, cl.getDocumento());
		    x=ps.executeUpdate();
		    if(x>0) {
		    	dat=true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR"+e);
		}
		
		return dat;	
	}
	public ArrayList<ClienteDTO> consultar(){
		ArrayList<ClienteDTO> lista=new  ArrayList<ClienteDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM cliente");
			rs=ps.executeQuery();
			while(rs.next()) {
				cli=new ClienteDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			   lista.add(cli);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}



}
