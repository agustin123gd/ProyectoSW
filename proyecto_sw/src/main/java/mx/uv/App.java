package mx.uv;
import com.google.gson.*;

import static spark.Spark.*;
import mx.uv.db.UsuarioDAO;
import mx.uv.db.Asignacion;
import mx.uv.db.AsignacionDAO;
import mx.uv.db.CuestionarioDAO;
import mx.uv.db.RespuestaAlumnoDAO;
import mx.uv.db.UsuarioDAO;
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
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        
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


        post("/validarUsuario", (req, res) -> {
            // Insertamos un nuevo usuario
            String json = req.body();
            Usuario usuario = gson.fromJson(json, Usuario.class);
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            int resultado = usuarioDAO.validarUsuario(usuario);
            System.out.println(resultado);
            return resultado;
    
        });
        
    }
}
