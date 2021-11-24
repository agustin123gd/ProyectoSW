package mx.uv.db;

public class Respuesta {
    private int id;
    private int idPregunta;
    private String respuesta;

    public Respuesta(int id, int idPregunta, String respuesta) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
    }
    public int getId() {
        return id;
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
