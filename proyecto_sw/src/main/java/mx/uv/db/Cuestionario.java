package mx.uv.db;

public class Cuestionario {
    private int id;
    private String nombre;
    private String creador;
    
    public Cuestionario(int id, String nombre, String creador) {
        this.id = id;
        this.nombre = nombre;
        this.creador = creador;
    }
    public int getId() {
        return id;
    }
    public String getCreador() {
        return creador;
    }
    public void setCreador(String creador) {
        this.creador = creador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
}
