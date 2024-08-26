/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.entidades;

/**
 *
 * @author hecto
 */
public class Brigada {
//    `CodBrigada``NombreBr``Especialidad``Libre``NroCuartel`
    private int CodBrigada;
    private String NombreBr;
    private String Especialidad;
    private boolean Libre;
    private Cuartel cuartel;
    private boolean estado;

    public Brigada() {
    }

    public Brigada(int CodBrigada, String NombreBr, String Especialidad, boolean Libre, Cuartel cuartel,boolean estado) {
        this.CodBrigada = CodBrigada;
        this.NombreBr = NombreBr;
        this.Especialidad = Especialidad;
        this.Libre = Libre;
        this.cuartel = cuartel;
        this.estado= estado;
    }

    public Brigada(String NombreBr, String Especialidad, boolean Libre, Cuartel cuartel,boolean estado) {
        this.NombreBr = NombreBr;
        this.Especialidad = Especialidad;
        this.Libre = Libre;
        this.cuartel = cuartel;
         this.estado= estado;
    }

    public int getCodBrigada() {
        return CodBrigada;
    }

    public void setCodBrigada(int CodBrigada) {
        this.CodBrigada = CodBrigada;
    }

    public String getNombreBr() {
        return NombreBr;
    }

    public void setNombreBr(String NombreBr) {
        this.NombreBr = NombreBr;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public boolean isLibre() {
        return Libre;
    }

    public void setLibre(boolean Libre) {
        this.Libre = Libre;
    }

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Brigada{" + "CodBrigada=" + CodBrigada + ", NombreBr=" + NombreBr + ", Especialidad=" + Especialidad + ", Libre=" + Libre + ", cuartel=" + cuartel + '}';
    }

    
}
