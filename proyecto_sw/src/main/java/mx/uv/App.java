package mx.uv;
import com.google.gson.*;
import com.mysql.jdbc.Connection;

import static spark.Spark.*;
import mx.uv.db.UsuarioDAO;
import java.util.UUID;

import mx.uv.db.Conexion;
import mx.uv.db.RespuestaAlumno;
import mx.uv.db.RespuestaAlumnoDAO;
import mx.uv.db.Usuario;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();
    public static void main( String[] args )
    {
        
        get("/", (req, res) -> {
            return null;
        });

        post("/usuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario u = gson.fromJson(json, Usuario.class);
            //usuarios.put(id, u);

            UsuarioDAO dao = new UsuarioDAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarUsuario(u));
            return respuesta;
        });
        
        get("/usuarios", (req, res) -> {
            before((req2, res2) -> res.type("application/json"));
            UsuarioDAO dao = new UsuarioDAO();
            return gson.toJson(dao.listadoUsuario());
        });

        get("/resultados",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            RespuestaAlumnoDAO dao = new RespuestaAlumnoDAO();
            return gson.toJson(dao.listadoRespuestas());
        });

        get("/conn",(req,res)->{
            Conexion conexion = new Conexion();
            Connection conn = null;
            conn = (Connection) conexion.getConnection();
            if(conn != null){
                return "nice";
            }else{
                return 1;
            }
        });
    }
}
