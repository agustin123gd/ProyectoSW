package mx.uv;
import com.google.gson.*;
import static spark.Spark.*;
import mx.uv.db.UsuarioDAO;
import java.util.UUID;
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
        
    }
}
