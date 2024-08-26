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
public class Cuartel {
//    `CodCuartel``NombreCuartel``Direccion``CoorX``CoorY``Telefono``Correo`
    private int CodCuartel;
    private String NombreCuartel,Direccion;
    private int CoorX,CoorY;
    private String Telefono,Correo;
    private boolean activo;

    public Cuartel() {
    }

    public Cuartel(int CodCuartel, String NombreCuartel, String Direccion, int CoorX, int CoorY, String Telefono, String Correo,boolean activo) {
        this.CodCuartel = CodCuartel;
        this.NombreCuartel = NombreCuartel;
        this.Direccion = Direccion;
        this.CoorX = CoorX;
        this.CoorY = CoorY;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public Cuartel(String NombreCuartel, String Direccion, int CoorX, int CoorY, String Telefono, String Correo,boolean activo) {
        this.NombreCuartel = NombreCuartel;
        this.Direccion = Direccion;
        this.CoorX = CoorX;
        this.CoorY = CoorY;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public int getCodCuartel() {
        return CodCuartel;
    }

    public void setCodCuartel(int CodCuartel) {
        this.CodCuartel = CodCuartel;
    }

    public String getNombreCuartel() {
        return NombreCuartel;
    }

    public void setNombreCuartel(String NombreCuartel) {
        this.NombreCuartel = NombreCuartel;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getCoorX() {
        return CoorX;
    }

    public void setCoorX(int CoorX) {
        this.CoorX = CoorX;
    }

    public int getCoorY() {
        return CoorY;
    }

    public void setCoorY(int CoorY) {
        this.CoorY = CoorY;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cuartel{" + "CodCuartel=" + CodCuartel + ", NombreCuartel=" + NombreCuartel + ", Direccion=" + Direccion + ", CoorX=" + CoorX + ", CoorY=" + CoorY + ", Telefono=" + Telefono + ", Correo=" + Correo + ", activo=" + activo + '}';
    }
    

   
    
}
