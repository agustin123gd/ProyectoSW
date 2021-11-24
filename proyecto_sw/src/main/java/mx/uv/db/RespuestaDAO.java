package mx.uv.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RespuestaDAO {
    private Conexion conexion = new Conexion();

    public String insertarRespuesta(Respuesta r) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO respuesta (id, idPregunta, respuesta) VALUES (?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, r.getId());
            prestm.setInt(2, r.getIdPregunta());
            prestm.setString(3, r.getRespuesta());
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

    public List<Respuesta> listadoRespuestas() {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Respuesta> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT * FROM respuesta";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Respuesta r = new Respuesta(rs.getInt("id"), rs.getInt("idPregunta"), rs.getString("respuesta"));
                resultado.add(r);
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
