package apps.udenar.edu.co.pastoapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Evento implements Serializable {

    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("expresi_n")
    @Expose
    private String expresiN;
    @SerializedName("actividad")
    @Expose
    private String actividad;
    @SerializedName("mbito")
    @Expose
    private String mbito;
    @SerializedName("equipamiento")
    @Expose
    private String equipamiento;
    @SerializedName("organizador")
    @Expose
    private String organizador;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getExpresiN() {
        return expresiN;
    }

    public void setExpresiN(String expresiN) {
        this.expresiN = expresiN;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getMbito() {
        return mbito;
    }

    public void setMbito(String mbito) {
        this.mbito = mbito;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }
    //https://www.datos.gov.co/resource/8wbc-7c6p.json
}
