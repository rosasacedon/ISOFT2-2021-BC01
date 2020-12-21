package org.iteracion3.Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.iteracion3.Persistencia.Agente_BBDD;

public class Gestor_cocina extends Agente_BBDD{

	public Gestor_cocina() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean actualizar_ingredientes() throws Exception {
		
		String sql = "SELECT * FROM ingredientes WHERE idingrediente=?";
		PreparedStatement ps = null;
		Connection con = (Connection) getAgente();
		
			try {
				ps = con.prepareStatement(sql);
				ResultSet resultado = ps.executeQuery(sql);
				if (resultado!=null){
					System.out.println("DECREMENTO DE INGREDIENTES:");
					while(resultado.next()){
						int id = resultado.getInt("idingrediente");
						String nombre = resultado.getString("nombre");
						System.out.println("Se ha utilizado un/a "+nombre);
						String sql1 = "UPDATE ingredientes SET cantidad= cantidad-'1' WHERE idingrediente="+id;
						PreparedStatement ps1 = null;
						Connection con1 = (Connection) getAgente();
						ps1 = con1.prepareStatement(sql1);
						ps1.executeUpdate(sql1);
						
					}
					System.out.print("\n\n");
					return true;
					
				}
				return true;

			}catch(SQLException ex) {
				Logger.getLogger(Gestor_almacen.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}
		
	}

}