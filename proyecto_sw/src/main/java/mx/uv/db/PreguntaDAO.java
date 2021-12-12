package mx.uv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PreguntaDAO {
    private Conexion conexion = new Conexion();

    public String insertarPregunta(Pregunta p) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO pregunta (id, idCuestionario, tipo, pregunta) VALUES (?, ?, ?,?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, p.getId());
            prestm.setInt(2, p.getIdCuestionario());
            prestm.setString(3, p.getTipo());
            prestm.setString(4, p.getPregunta());
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

    public List<Pregunta> listadoPregunta(int idCuestionario) {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Pregunta> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT id, tipo, pregunta FROM pregunta Where idCuestionario="+idCuestionario;
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Pregunta p = new Pregunta(rs.getInt("id"), 0, rs.getString("tipo"), rs.getString("pregunta"));
                resultado.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    stm = null;
                    e.printStackTrace();
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    rs = null;
                    e.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
}
