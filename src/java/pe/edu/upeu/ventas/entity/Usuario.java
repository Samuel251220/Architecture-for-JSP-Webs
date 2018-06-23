package pe.edu.upeu.ventas.entity;

/**
 *
 * @author alum.fial1
 */
public class Usuario {
    private int idusuario;
    private String nom_user;
    private String clave;
    private String estado;
    private int idrol;
    private int idpersona;

    public Usuario() {
    }

    public Usuario(String nom_user, String clave, String estado, int idrol, int idpersona) {
        this.nom_user = nom_user;
        this.clave = clave;
        this.estado = estado;
        this.idrol = idrol;
        this.idpersona = idpersona;
    }

    public Usuario(int idusuario, String nom_user, String clave, String estado, int idrol, int idpersona) {
        this.idusuario = idusuario;
        this.nom_user = nom_user;
        this.clave = clave;
        this.estado = estado;
        this.idrol = idrol;
        this.idpersona = idpersona;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
    
}
