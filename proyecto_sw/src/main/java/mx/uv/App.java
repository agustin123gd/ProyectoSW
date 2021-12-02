package mx.uv;
import com.google.gson.*;
import static spark.Spark.*;
import mx.uv.db.DAO;
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

            DAO dao = new DAO();
            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("status", dao.insertarUsuario(u));
            return respuesta;
        });
        
        get("/usuarios", (req, res) -> {
            before((req2, res2) -> res.type("application/json"));
            DAO dao = new DAO();
            return gson.toJson(dao.listadoUsuario());
        });


        get("/validar", (rq, rs) -> {
            DAO dao = new DAO();
            Usuario u;
            String correo = rq.queryParams("correo");
            String contraseña = rq.queryParams("contraseña");
            String tipo = rq.queryParams("tipo");
            u = dao.BuscarUsuario(correo);
                if(u != null){
                    if (contraseña.equals(String.valueOf(u.getContraseña()))) {
                        System.out.println("Existe el Alumno");
                    } else {
                        System.out.println("No existe el Alumno");
                    }
                }
            return null;
        });
        
    }
}
