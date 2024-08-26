/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.accesoADatos;

import bomberosgrupo47.entidades.Brigada;
import bomberosgrupo47.entidades.Siniestro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hecto
 */
public class SiniestroData {
      private Connection con=null;
      private BrigadaData bd=new BrigadaData();
    public SiniestroData(){
    con=Conexion.getConexion();
    }

    public void guardarSiniestro(Siniestro siniestro){
//     `siniestro``Codigo``tipo``FechaSiniestro``CoordX``CoordY``Detalles``FechaResol``Puntuacion``CodBrigada`
// INSERT INTO `siniestro`( `tipo`, `FechaSiniestro`, `CoordX`, `CoordY`, `Detalles`, `FechaResol`, `Puntuacion`, `CodBrigada`) 
    String sql="INSERT INTO siniestro (tipo,FechaSiniestro,CoordX, CoordY, Detalles,FechaResol,Puntuacion,CodBrigada)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,siniestro.getTipo());
            ps.setDate(2,Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setInt(3,siniestro.getCoordX());
            ps.setInt(4,siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
            ps.setDate(6,Date.valueOf(siniestro.getFechaResol()));
            ps.setInt(7,siniestro.getPuntuacion());
            ps.setInt(8,siniestro.getBrigada().getCodBrigada());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                
                siniestro.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Siniestro agregado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al agregar Siniestro"+ex);
        }
        
    }
    
    public void guardarSinResolver(Siniestro siniestro){
//     `siniestro``Codigo``tipo``FechaSiniestro``CoordX``CoordY``Detalles``FechaResol``Puntuacion``CodBrigada`
// INSERT INTO `siniestro`( `tipo`, `FechaSiniestro`, `CoordX`, `CoordY`, `Detalles`, `FechaResol`, `Puntuacion`, `CodBrigada`) 
    String sql="INSERT INTO siniestro (tipo,FechaSiniestro,CoordX, CoordY, Detalles,CodBrigada)"
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,siniestro.getTipo());
            ps.setDate(2,Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setInt(3,siniestro.getCoordX());
            ps.setInt(4,siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
//            ps.setDate(6,Date.valueOf(siniestro.getFechaResol()));
//            ps.setInt(7,siniestro.getPuntuacion());
            ps.setInt(6,siniestro.getBrigada().getCodBrigada());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                
                siniestro.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Siniestro agregado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al agregar Siniestro"+ex);
        }
        
    }
    
    
     public void modificarSiniestro(Siniestro siniestro){
//         UPDATE `siniestro` SET `Codigo`='[value-1]',`tipo`='[value-2]',`FechaSiniestro`='[value-3]',`CoordX`='[value-4]',`CoordY`='[value-5]',`Detalles`='[value-6]',`FechaResol`='[value-7]',`Puntuacion`='[value-8]',`CodBrigada`='[value-9]' WHERE 1
         
    String sql="UPDATE siniestro SET tipo=?,FechaSiniestro=?, CoordX=?, CoordY=?,Detalles=?,FechaResol=?,Puntuacion=?,CodBrigada=? WHERE Codigo=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, siniestro.getTipo());
            ps.setDate(2,Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setInt(3,siniestro.getCoordX());
            ps.setInt(4,siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
            ps.setDate(6, Date.valueOf(siniestro.getFechaResol()));
            ps.setInt(7, siniestro.getPuntuacion());
            ps.setInt(8,siniestro.getBrigada().getCodBrigada());
            ps.setInt(9,siniestro.getCodigo());
            int e= ps.executeUpdate();
            System.out.println(""+e);
            if (e==1) {
                JOptionPane.showMessageDialog(null,"Siniestro modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al modificar Siniestro"+ex);
        }
    }
    
      public void modificarSinResolver(Siniestro siniestro){
//         UPDATE `siniestro` SET `Codigo`='[value-1]',`tipo`='[value-2]',`FechaSiniestro`='[value-3]',`CoordX`='[value-4]',`CoordY`='[value-5]',`Detalles`='[value-6]',`FechaResol`='[value-7]',`Puntuacion`='[value-8]',`CodBrigada`='[value-9]' WHERE 1
         
    String sql="UPDATE siniestro SET tipo=?,FechaSiniestro=?, CoordX=?, CoordY=?,Detalles=?,CodBrigada=? WHERE Codigo=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, siniestro.getTipo());
            ps.setDate(2,Date.valueOf(siniestro.getFechaSiniestro()));
            ps.setInt(3,siniestro.getCoordX());
            ps.setInt(4,siniestro.getCoordY());
            ps.setString(5, siniestro.getDetalles());
            
            
            ps.setInt(6,siniestro.getBrigada().getCodBrigada());
            ps.setInt(7,siniestro.getCodigo());
            int e= ps.executeUpdate();
            System.out.println(""+e);
            if (e==1) {
                JOptionPane.showMessageDialog(null,"Siniestro modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al modificar Siniestro"+ex);
        }
    }
    
    public ArrayList<Siniestro> obtenerSiniestro (){

    ArrayList<Siniestro> siniestros= new ArrayList();
    String sql="SELECT * FROM siniestro";

        try {
            PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
            while (rs.next()) {
               Siniestro sinie= new Siniestro();
               sinie.setCodigo(rs.getInt("Codigo"));
               sinie.setTipo(rs.getString("tipo"));
               sinie.setTipo(rs.getString("tipo"));
               sinie.setFechaSiniestro(rs.getDate("FechaSiniestro").toLocalDate());
               sinie.setCoordX(rs.getInt("CoordX"));
               sinie.setCoordY(rs.getInt("CoordY"));
               sinie.setDetalles(rs.getString("Detalles"));
               sinie.setFechaResol(rs.getDate("FechaResol").toLocalDate());
               
               sinie.setPuntuacion(rs.getInt("Puntuacion"));
               Brigada bri =bd.buscarBrigada(rs.getInt("CodBrigada"));
               
               sinie.setBrigada(bri);
               
               
               siniestros.add(sinie);
            }
            ps.close();

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
       return siniestros;
}
//    SELECT * FROM `siniestro` WHERE `Codigo`
    public Siniestro buscarSiniestro(int codigo) {
//`Codigo``tipo``FechaSiniestro``CoordX``CoordY``Detalles``FechaResol``Puntuacion``CodBrigada`
        String sql = "SELECT Codigo, tipo, FechaSiniestro, CoordX, CoordY, Detalles, FechaResol, Puntuacion, CodBrigada FROM siniestro WHERE Codigo = ?";

        Siniestro siniestro = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                siniestro = new Siniestro();

                siniestro.setCodigo(rs.getInt("Codigo"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFechaSiniestro(rs.getDate("FechaSiniestro").toLocalDate());
                siniestro.setCoordX(rs.getInt("CoordX"));
                siniestro.setCoordY(rs.getInt("CoordY"));
                siniestro.setDetalles(rs.getString("Detalles"));
                if (rs.getDate("FechaResol")!=null) {
                    siniestro.setFechaResol(rs.getDate("FechaResol").toLocalDate());
                    siniestro.setPuntuacion(rs.getInt("Puntuacion"));
                }
                
                Brigada brigada = bd.buscarBrigada(rs.getInt("CodBrigada"));
                siniestro.setBrigada(brigada);
                

            } else {

                JOptionPane.showMessageDialog(null, "SINIESTRO no encontrado con ese CODIGO");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla SINIESTRO");
        }
        return siniestro;
    }
    
    public ArrayList<Siniestro> obtenerSiniestro2 (){

    ArrayList<Siniestro> siniestros= new ArrayList();
    String sql="SELECT * FROM siniestro";

        try {
            PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
            while (rs.next()) {
               Siniestro sinie= new Siniestro();
               sinie.setCodigo(rs.getInt("Codigo"));
               sinie.setTipo(rs.getString("tipo"));
               
               sinie.setDetalles(rs.getString("Detalles"));
               
               
              
               
               
               siniestros.add(sinie);
            }
            ps.close();

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
       return siniestros;
}

    public int ayerHoySiniestro() {
//`Codigo``tipo``FechaSiniestro``CoordX``CoordY``Detalles``FechaResol``Puntuacion``CodBrigada`
        String sql = "SELECT COUNT(`tipo`) FROM `siniestro` WHERE DATE(`FechaSiniestro`) BETWEEN  CURDATE() - INTERVAL 1 DAY AND CURDATE()";

        int contador = 0;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                 contador = rs.getInt(1); // Obtenemos el resultado del COUNT
                
                

            } else {

                JOptionPane.showMessageDialog(null, "SINIESTRO no encontrado con ese CODIGO");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla SINIESTRO");
        }
        return contador;
    }
    
//    SELECT COUNT(`tipo`) FROM `siniestro`;
    public int TotalSiniestro() {
//`Codigo``tipo``FechaSiniestro``CoordX``CoordY``Detalles``FechaResol``Puntuacion``CodBrigada`
        String sql = "SELECT COUNT(`tipo`) FROM `siniestro`";

        int contador = 0;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                 contador = rs.getInt(1); // Obtenemos el resultado del COUNT
               
                

            } else {

                JOptionPane.showMessageDialog(null, "SINIESTRO no encontrado ");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla SINIESTRO");
        }
        return contador;
    }
}
