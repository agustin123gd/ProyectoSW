package mx.uv;
import com.google.gson.*;

import static spark.Spark.*;
import mx.uv.db.UsuarioDAO;
import mx.uv.db.Asignacion;
import mx.uv.db.AsignacionDAO;
import mx.uv.db.CuestionarioDAO;
import mx.uv.db.PreguntaDAO;
import mx.uv.db.RespuestaAlumnoDAO;
import mx.uv.db.RespuestaDAO;
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

        get("/resultados",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            RespuestaAlumnoDAO dao = new RespuestaAlumnoDAO();
            return gson.toJson(dao.listadoRespuestas(Integer.parseInt(req.queryParams("idUsuario")),Integer.parseInt(req.queryParams("idCuestionario"))));
        });

        get("/cuestionarios",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            CuestionarioDAO dao = new CuestionarioDAO();
            return gson.toJson(dao.listadoCuestionario());
        });
        get("/asignacion",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            AsignacionDAO dao = new AsignacionDAO();
            return gson.toJson(dao.listadoAsignacion(Integer.parseInt(req.queryParams("idCuestionario"))));
        });
        
        get("/asignacionPorUsuario",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            AsignacionDAO dao = new AsignacionDAO();
            return gson.toJson(dao.asignacionPorUsuario(Integer.parseInt(req.queryParams("idUsuario"))));
        });

        get("/preguntas",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            PreguntaDAO dao = new PreguntaDAO();
            return gson.toJson(dao.listadoPregunta((Integer.parseInt(req.queryParams("idCuestionario")))));
        });
        
        get("/respuestas",(req,res)->{
            before((req2, res2) -> res.type("application/json"));
            RespuestaDAO dao = new RespuestaDAO();
            return gson.toJson(dao.listadoRespuestas((Integer.parseInt(req.queryParams("idPregunta")))));
        });
    }
}
