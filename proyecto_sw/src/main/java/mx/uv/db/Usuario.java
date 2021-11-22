package mx.uv.db;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String tipo;

    public Usuario(String id,String nombre, String correo, String contraseña, String tipo) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getId() {
        return id;
    }
    public String getCorreo() {
        return correo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public String getContraseña() {
        return contraseña;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}