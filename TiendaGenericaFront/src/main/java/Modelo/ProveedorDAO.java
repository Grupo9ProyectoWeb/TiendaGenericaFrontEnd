package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidad.ProveedorDTO;
import conexion.Conexion;

public class ProveedorDAO {

	Conexion con=new Conexion();
	Connection cnn =con.getConexion();
	PreparedStatement ps;
	ResultSet rs;
	ProveedorDTO pro;

	public String insertarproveedor(ProveedorDTO pr) {
		int x;
		String dat="";
		try {
			pro=consultarproveedor(pr);
			if(pro==null) {
				ps=cnn.prepareStatement("INSERT INTO proveedor VALUES(?,?,?,?,?)");
				ps.setInt(1, pr.getNIT());
				ps.setString(2, pr.getNomcompleto());
				ps.setString(3, pr.getTelefono());
				ps.setString(4, pr.getCiudad());
				ps.setString(5, pr.getDireccion());
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


	public  ProveedorDTO consultarproveedor(ProveedorDTO us) {
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM proveedor WHERE documento=?");
		ps.setInt(1, us.getNIT());
		rs=ps.executeQuery();
		if(rs.next()) {
		   pro=new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return pro;
	}



	public int eliminar(ProveedorDTO pr) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM proveedor WHERE documento=? ");
		ps.setInt(1, pr.getNIT());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(ProveedorDTO pr) {
		boolean dat=false;
		JOptionPane.showMessageDialog(null, "dao"+pr.getNIT());
		JOptionPane.showMessageDialog(null, pr.getNomcompleto());
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE proveedor SET nomcompleto=?,telefono=?,ciudad=?,direccion=? WHERE NIT=?");
		    ps.setString(1, pr.getNomcompleto());
		    ps.setString(2, pr.getTelefono());
		    ps.setString(3, pr.getCiudad());
		    ps.setString(4, pr.getDireccion());
		    ps.setInt(5, pr.getNIT());
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
	public ArrayList<ProveedorDTO> consultar(){
		ArrayList<ProveedorDTO> lista=new  ArrayList<ProveedorDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedor");
			rs=ps.executeQuery();
			while(rs.next()) {
				pro=new ProveedorDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			   lista.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
