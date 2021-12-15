package mx.uv.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

public class VideoDao {
    private Conexion conexion = new Conexion();

    public String insertarVideo(Video vi) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO video (idUsuario, idCuestionario, video) VALUES (?, ?, ?)";
            prestm = conn.prepareStatement(sql);
            prestm.setInt(1, vi.getIdUsuario());
            prestm.setInt(2, vi.getIdCuestionario());
            prestm.setString(3, vi.getVideo());
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

    

    public List<Video> listadoVideos( int idUsuario,int idCuestionario) {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Video> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT video FROM video where idUsuario="+ idUsuario +" and idCuestionario="+idCuestionario;
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Video ra = new Video(idUsuario, idCuestionario, rs.getString(1));
                resultado.add(ra);
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
