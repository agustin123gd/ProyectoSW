package mx.uv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsignacionDAO {
    private Conexion conexion = new Conexion();

    public String crearAsignacion(Asignacion a) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO asignacion (id, idUsuario, idCuestioanrio) VALUES (?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, a.getId());
            prestm.setInt(2, a.getIdUsurio());
            prestm.setInt(3, a.getIdCuestionario());
            if (prestm.executeUpdate() >0) 
                msj = "Usuario agregado";
            else
                msj = "No se agregó el usuario";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestm != null){
                try {
                    prestm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return msj;
    }
}
