/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.entidades;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author hecto
 */
public class Bombero {
//    `idBombero``dni``NombreApellido``FechaNac``Celular``CodBrigada`
    private int idBombero;
    private int dni;
    private String NombreApellido;
    private LocalDate FechaNac;
    private String Celular;
    private Brigada brigada;
    private String grupoSanguineo;

    public Bombero() {
    }

    public Bombero(int idBombero, int dni, String NombreApellido, LocalDate FechaNac, String Celular,String grupoSanguineo, Brigada brigada) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.NombreApellido = NombreApellido;
        this.FechaNac = FechaNac;
        this.Celular = Celular;
        this.brigada = brigada;
        this.grupoSanguineo=grupoSanguineo;
    }

    public Bombero(int dni, String NombreApellido, LocalDate FechaNac, String Celular,String grupoSanguineo, Brigada brigada) {
        this.dni = dni;
        this.NombreApellido = NombreApellido;
        this.FechaNac = FechaNac;
        this.Celular = Celular;
        this.brigada = brigada;
        this.grupoSanguineo=grupoSanguineo;
    }

    public int getIdBombero() {
        return idBombero;
    }

    public void setIdBombero(int idBombero) {
        this.idBombero = idBombero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return NombreApellido;
    }

    public void setNombreApellido(String NombreApellido) {
        this.NombreApellido = NombreApellido;
    }

    public LocalDate getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(LocalDate FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    

    @Override
    public String toString() {
        return "Bombero{" + "idBombero=" + idBombero + ", dni=" + dni + ", NombreApellido=" + NombreApellido + ", FechaNac=" + FechaNac + ", Celular=" + Celular + ", brigada=" + brigada + '}';
    }
    

    
    
}
