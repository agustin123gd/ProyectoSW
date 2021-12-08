package mx.uv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;

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

    public List<Asignacion> listadoAsignacion(int id) {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Asignacion> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT usuario.id, usuario.nombre, asignacion.estado From asignacion Inner JOIN usuario on asignacion.idUsuario = usuario.id WHERE asignacion.idCuestionario=" + id;
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Asignacion a = new Asignacion(rs.getInt("id"), rs.getString("nombre"), rs.getString("estado"));
                resultado.add(a);
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

    public List<Asignacion> asignacionPorUsuario(int id) {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Asignacion> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "select cuestionario.id, cuestionario.nombre From Cuestionario inner join asignacion on Cuestionario.id = asignacion.idCuestionario where asignacion.idUsuario ="+id+" and asignacion.estado = 'Pendiente'";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Asignacion a = new Asignacion(rs.getInt("id"), rs.getString("nombre"),null);
                resultado.add(a);
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
