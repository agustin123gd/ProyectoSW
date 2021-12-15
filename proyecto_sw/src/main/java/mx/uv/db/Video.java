package mx.uv.db;

public class Video {
    private int id;
    private int idUsuario;
    private int idCuestionario;

    public Video( int idUsuario, int idCuestionario, String video) {
        this.idUsuario = idUsuario;
        this.idCuestionario = idCuestionario;
        this.video = video;
    }
    public Video() {
    }
    private String video;
    public int getId() {
        return id;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    public int getIdCuestionario() {
        return idCuestionario;
    }
    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
}
