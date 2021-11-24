package mx.uv.db;

public class Asignacion {
    private int id;
    private int idUsurio;
    private int idCuestionario;
    
    public Asignacion(int id, int idUsurio, int idCuestionario) {
        this.id = id;
        this.idUsurio = idUsurio;
        this.idCuestionario = idCuestionario;
    }
    public int getId() {
        return id;
    }
    public int getIdCuestionario() {
        return idCuestionario;
    }
    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }
    public int getIdUsurio() {
        return idUsurio;
    }
    public void setIdUsurio(int idUsurio) {
        this.idUsurio = idUsurio;
    }
    public void setId(int id) {
        this.id = id;
    }
    

}
