package apps.udenar.edu.co.pastoapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hotel implements Serializable {
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("entidad_cargo")
    @Expose
    private String entidadCargo;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("contacto")
    @Expose
    private String contacto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntidadCargo() {
        return entidadCargo;
    }

    public void setEntidadCargo(String entidadCargo) {
        this.entidadCargo = entidadCargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}

