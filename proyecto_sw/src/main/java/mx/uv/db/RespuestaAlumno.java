package mx.uv.db;

public class RespuestaAlumno {
    private int id;
    private int idPregunta;
    private String respuesta;
    private int idUsuario;
    public RespuestaAlumno(int id, int idPregunta, String respuesta, int idUsuario) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
        this.idUsuario = idUsuario;
    }
    public int getId() {
        return id;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public int getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }
    public void setId(int id) {
        this.id = id;
    }
}
