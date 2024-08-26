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
public class Siniestro {
//    `Codigo``tipo``FechaSiniestro``CoordX``CoordY``Detalles``FechaResol``Puntuacion``CodBrigada`
    private int Codigo;
    private String tipo;
    private LocalDate FechaSiniestro;
    private int CoordX,CoordY;
    private String Detalles;
    private LocalDate FechaResol;
    private int Puntuacion;
    private Brigada brigada;

    public Siniestro() {
    }

    public Siniestro(String tipo, LocalDate FechaSiniestro, int CoordX, int CoordY, String Detalles,  Brigada brigada) {
        this.tipo = tipo;
        this.FechaSiniestro = FechaSiniestro;
        this.CoordX = CoordX;
        this.CoordY = CoordY;
        this.Detalles = Detalles;
        this.brigada = brigada;
    }
    

    public Siniestro(int Codigo, String tipo, LocalDate FechaSiniestro, int CoordX, int CoordY, String Detalles, LocalDate FechaResol, int Puntuacion, Brigada brigada) {
        this.Codigo = Codigo;
        this.tipo = tipo;
        this.FechaSiniestro = FechaSiniestro;
        this.CoordX = CoordX;
        this.CoordY = CoordY;
        this.Detalles = Detalles;
        this.FechaResol = FechaResol;
        this.Puntuacion = Puntuacion;
        this.brigada = brigada;
    }

    public Siniestro(String tipo, LocalDate FechaSiniestro, int CoordX, int CoordY, String Detalles, LocalDate FechaResol, int Puntuacion, Brigada brigada) {
        this.tipo = tipo;
        this.FechaSiniestro = FechaSiniestro;
        this.CoordX = CoordX;
        this.CoordY = CoordY;
        this.Detalles = Detalles;
        this.FechaResol = FechaResol;
        this.Puntuacion = Puntuacion;
        this.brigada = brigada;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaSiniestro() {
        return FechaSiniestro;
    }

    public void setFechaSiniestro(LocalDate FechaSiniestro) {
        this.FechaSiniestro = FechaSiniestro;
    }

    public int getCoordX() {
        return CoordX;
    }

    public void setCoordX(int CoordX) {
        this.CoordX = CoordX;
    }

    public int getCoordY() {
        return CoordY;
    }

    public void setCoordY(int CoordY) {
        this.CoordY = CoordY;
    }

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }

    public LocalDate getFechaResol() {
        return FechaResol;
    }

    public void setFechaResol(LocalDate FechaResol) {
        this.FechaResol = FechaResol;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int Puntuacion) {
        this.Puntuacion = Puntuacion;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }

    @Override
    public String toString() {
        return "Siniestro" + " Cod=" + Codigo + "," + tipo;
    }

    
}
