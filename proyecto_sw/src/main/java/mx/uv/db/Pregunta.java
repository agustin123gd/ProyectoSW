package mx.uv.db;

public class Pregunta {
    private int id;
    private int idCuestionario;
    private String tipo;
    private String pregunta;
    
    public Pregunta(int id, int idCuestionario, String tipo, String pregunta) {
        this.id = id;
        this.idCuestionario = idCuestionario;
        this.tipo = tipo;
        this.pregunta = pregunta;
    }
    
    public int getId() {
        return id;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getIdCuestionario() {
        return idCuestionario;
    }
    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
