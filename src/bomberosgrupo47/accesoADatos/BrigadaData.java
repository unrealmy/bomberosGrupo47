/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.accesoADatos;

import bomberosgrupo47.entidades.Bombero;
import bomberosgrupo47.entidades.Brigada;
import bomberosgrupo47.entidades.Cuartel;
import java.sql.Connection;
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
public class BrigadaData {
    private Connection con=null;
    private CuartelData brid=new CuartelData();
    public BrigadaData(){
    con=Conexion.getConexion();
    }
    
    public void guardarBrigada(Brigada brigada){
//        `CodBrigada``NombreBr``Especialidad``Libre``NroCuartel`
    String sql="INSERT INTO brigada (NombreBr, Especialidad, Libre, NroCuartel,estado)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombreBr());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3,brigada.isLibre());
            ps.setInt(4,brigada.getCuartel().getCodCuartel());
            ps.setBoolean(5, true);
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                
                brigada.setCodBrigada(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"brigada agregada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al agregar brigada");
        }
    }
    
     public Brigada buscarBrigada (int id){
//SELECT `NombreBr``Especialidad``Libre``NroCuartel` FROM `brigada` WHERE `CodBrigada`
        String sql = "SELECT NombreBr, Especialidad, Libre, NroCuartel FROM brigada WHERE  CodBrigada = ?" ;
        
        Brigada brigada=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                
                brigada=new Brigada();
               brigada.setCodBrigada(id);
                brigada.setNombreBr(rs.getString("NombreBr"));
                brigada.setEspecialidad(rs.getString("Especialidad"));
                brigada.setLibre(true);
               Cuartel cuartel=brid.buscarCuartel(rs.getInt("NroCuartel"));
               brigada.setCuartel(cuartel);

            } else {
                            
                JOptionPane.showMessageDialog(null, "Brigada no encontrado con ese ID");
                
            }
                ps.close();   
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    
            return brigada;
}
     

      public ArrayList<Brigada> buscarBrigadaPorCuartel (int id){
//SELECT `NombreBr``Especialidad``Libre``NroCuartel` FROM `brigada` WHERE `CodBrigada`

//     SELECT `CodBrigada`, `NombreBr`, `Especialidad`, `Libre` FROM `brigada` WHERE NroCuartel=?
        String sql = "SELECT CodBrigada, NombreBr, Especialidad,  NroCuartel FROM brigada WHERE  NroCuartel = ? AND Libre=1" ;
        
        
        ArrayList<Brigada> brig = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
//            while (rs.next()) {
//                inscripcion insc = new inscripcion();
//                insc.setIdIscripcion(rs.getInt("idIscripcion"));
//                alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
//                materia mat = md.buscarMateriaId(rs.getInt("idMateria"));
//                insc.setAlumno(alu);
//                insc.setMateria(mat);
//                insc.setNota(rs.getDouble("nota"));
//                cursadas.add(insc);
//            }
//            ps.close();
            while(rs.next()){
                Brigada brigada=new Brigada();
               
                brigada.setCodBrigada(rs.getInt("CodBrigada"));
                brigada.setNombreBr(rs.getString("NombreBr"));
                brigada.setEspecialidad(rs.getString("Especialidad"));
//                brigada.setLibre(rs.getBoolean("Libre"));
               Cuartel cuartel=brid.buscarCuartel(rs.getInt("NroCuartel"));
               brigada.setCuartel(cuartel);
               brig.add(brigada);

            }
                ps.close();   
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    
            return brig;
}
      public ArrayList<Brigada> listarBPorEspecialidad(String espe) {

        String sql = "SELECT * FROM brigada WHERE especialidad = ? AND Libre=1";

        ArrayList<Brigada> brigadas = new ArrayList();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, espe);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {

                Brigada brigada = new Brigada();
                brigada.setCodBrigada(rs.getInt("codBrigada"));
                brigada.setNombreBr(rs.getString("nombre_br"));
                brigada.setEspecialidad(rs.getString("especialidad"));
                brigada.setLibre(rs.getBoolean("libre"));
                Cuartel cuartel=brid.buscarCuartel(rs.getInt("nro_cuartel"));
                brigada.setCuartel(cuartel);
                
                brigadas.add(brigada);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }

        return brigadas;
    }
      
      public void modificarBrigada(Brigada brigada) {
          
//          `CodBrigada``NombreBr``Especialidad``Libre``NroCuartel`
        String sql = "UPDATE brigada SET NombreBr = ?, Especialidad = ?, Libre = ?, NroCuartel = ? WHERE CodBrigada = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, brigada.getNombreBr());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getCuartel().getCodCuartel());
            ps.setInt(5, brigada.getCodBrigada());
            //ps.executeUpdate();
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Brigada Modificada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    }
      
      public Brigada buscarBrigadaPorEsp (int id,String esp1){
//SELECT `NombreBr``Especialidad``Libre``NroCuartel` FROM `brigada` WHERE `CodBrigada`
        String sql = "SELECT NombreBr, NroCuartel FROM brigada WHERE  CodBrigada = ? AND Especialidad=? AND Libre=1" ;
        
        Brigada brigada=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, esp1);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                
                brigada=new Brigada();
               brigada.setCodBrigada(id);
                brigada.setNombreBr(rs.getString("NombreBr"));
//                brigada.setEspecialidad(rs.getString("Especialidad"));
//                brigada.setLibre(true);
               Cuartel cuartel=brid.buscarCuartel(rs.getInt("NroCuartel"));
               brigada.setCuartel(cuartel);

            } else {
                            
                JOptionPane.showMessageDialog(null, "no se encontro brigada");
                
            }
                ps.close();   
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    
            return brigada;
}
      
      
       public boolean BrigadaEspacio (int id){
//SELECT `NombreBr``Especialidad``Libre``NroCuartel` FROM `brigada` WHERE `CodBrigada`
//        String sql = "SELECT NombreBr, Especialidad, Libre, NroCuartel FROM brigada WHERE  CodBrigada = ?" ;
     String sql ="SELECT COUNT(`CodBrigada`) FROM bombero WHERE CodBrigada=?";

        boolean brigada=true;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                
              int conteo = rs.getInt(1);
                if (conteo>6) {
                    brigada=false;
                }
              

            } else {
                            
                JOptionPane.showMessageDialog(null, "Brigada ??");
                
            }
                ps.close();   
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    
            return brigada;
}
         public ArrayList<Brigada> buscarBrigadaPorCuartel2 (int id){

        String sql = "SELECT CodBrigada, NombreBr, Especialidad,Libre,  NroCuartel FROM brigada WHERE  NroCuartel = ? and estado=1" ;
        
        
        ArrayList<Brigada> brig = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Brigada brigada=new Brigada();
               
                brigada.setCodBrigada(rs.getInt("CodBrigada"));
                brigada.setNombreBr(rs.getString("NombreBr"));
                brigada.setEspecialidad(rs.getString("Especialidad"));
               brigada.setLibre(rs.getBoolean("Libre"));
               Cuartel cuartel=brid.buscarCuartel(rs.getInt("NroCuartel"));
               brigada.setCuartel(cuartel);
               brig.add(brigada);

            }
                ps.close();   
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada"+ex);
        }
    
            return brig;
}
    
         
         public void eliminarBrigada(int id) {

        BomberoData cargar = new BomberoData();

        ArrayList<Bombero> listBombero= cargar.listarBomberosXbrig(id);
        if (listBombero == null || listBombero.size() == 0) {
//            UPDATE brigada SET estado =0 WHERE CodBrigada = 13
            String sql = "UPDATE brigada SET estado =0 WHERE CodBrigada = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            int exito =ps.executeUpdate();
            if(exito==1){
            
            JOptionPane.showMessageDialog(null, "Brigada eliminado");

        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");


        }
        }else{
        JOptionPane.showMessageDialog(null, "brigada no se puede eliminar porque tiene bomberos registrados");
        }
        
        

    }
         
         public Brigada buscarBrigadaActivas (int id){
//SELECT `NombreBr``Especialidad``Libre``NroCuartel` FROM `brigada` WHERE `CodBrigada`
        String sql = "SELECT NombreBr, Especialidad, Libre, NroCuartel FROM brigada WHERE  CodBrigada = ? and estado=1" ;
        
        Brigada brigada=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                
                brigada=new Brigada();
               brigada.setCodBrigada(id);
                brigada.setNombreBr(rs.getString("NombreBr"));
                brigada.setEspecialidad(rs.getString("Especialidad"));
                brigada.setLibre(true);
               Cuartel cuartel=brid.buscarCuartel(rs.getInt("NroCuartel"));
               brigada.setCuartel(cuartel);

            } else {
                            
                JOptionPane.showMessageDialog(null, "Brigada no encontrado con ese ID");
                
            }
                ps.close();   
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    
            return brigada;
}
     
}
