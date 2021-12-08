package mx.uv.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Conexion conexion = new Conexion();

    public String insertarUsuario(Usuario u) {
        Connection conn = null;
        PreparedStatement prestm = null;
        String msj = "";

        conn = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuario (id, nombre, correo, contraseña, tipo) VALUES (?, ?, ?,?,?)";
            prestm = conn.prepareStatement(sql);
            prestm.setString(1, u.getId());
            prestm.setString(2, u.getNombre());
            prestm.setString(3, u.getCorreo());
            prestm.setString(4, u.getContraseña());
            prestm.setString(5, u.getTipo());
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

    public int validarUsuario(Usuario usuario) throws Exception{
        Statement stm;
        ResultSet usuarios;
        String sql = "select * from usuario;";
        
        try (Connection conn = conexion.getConnection();){
            stm = conn.createStatement();
            usuarios = stm.executeQuery(sql);
            System.out.println(usuarios);
            while (usuarios.next()){
                Usuario u = new Usuario(usuarios.getString("correo"), usuarios.getString("contraseña"), usuarios.getString("tipo"));
                
                    if(usuarios.getString("correo").equals(u.getCorreo()) && usuarios.getString("contraseña").equals(u.getContraseña())){
                        if (usuarios.getString("tipo").equals(u.getTipo())){
                            System.out.println("BIEN ADENTRO CHAVALEEE");
                            if (usuarios.getString("tipo").equals(u.getTipo())){
                                return 1;
                            }                      
                        }else{
                            System.out.println("NO ESTOY ADENTRO");
                            return 0;
                        }
                    }else{
                        System.out.println("NO ESTOY ADENTRO2");
                        return 0;
                    }
                
            }
        }catch (SQLException e) {
            throw new Exception("Error en readAll SQLException " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Error en readAll Exception " + e.getMessage());
        }
        return -1;
    }

    public List<Usuario> listadoUsuario() {
        Statement stm = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>(); 

        conn = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contraseña"), rs.getString("tipo"));
                resultado.add(u);
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
