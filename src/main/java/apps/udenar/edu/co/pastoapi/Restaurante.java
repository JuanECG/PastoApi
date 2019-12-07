package apps.udenar.edu.co.pastoapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Restaurante implements Serializable {

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
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("latitud")
    @Expose
    private String latitud;
    @SerializedName("longitud")
    @Expose
    private String longitud;
    @SerializedName("celular")
    @Expose
    private String celular;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }



    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
