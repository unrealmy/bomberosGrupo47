/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.accesoADatos;

import bomberosgrupo47.entidades.Bombero;
import bomberosgrupo47.entidades.Brigada;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.time.LocalDate;

public class BomberoData {

    private Connection con = null;
    private BrigadaData brid = new BrigadaData();

    public BomberoData() {
        con = Conexion.getConexion();
    }

    public void guardarBombero(Bombero bombero) {
//        dni`, `NombreApellido`, `FechaNac`, `Celular`, `CodBrigada
        String sql = "INSERT INTO bombero (dni, NombreApellido, FechaNac, Celular,grupoSanguineo, CodBrigada)"
                + "VALUES (? ,? ,? ,? ,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bombero.getDni());
            ps.setString(2, bombero.getNombreApellido());
            //ps.setDate(3,Date.valueOf(bombero.getFechaNac()));
            ps.setDate(3,Date.valueOf(bombero.getFechaNac()) );
            ps.setString(4, bombero.getCelular());
            ps.setString(5, bombero.getGrupoSanguineo());
            ps.setInt(6, bombero.getBrigada().getCodBrigada());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                bombero.setIdBombero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Bombero agregado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error 404");
        }
    }
    
     public void bajaBombero(int id) {
        String sql = "DELETE FROM bombero WHERE idBombero = ?";

        try {
            // Establece el valor del parámetro
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            

            
            
            // Verifica si se eliminó correctamente el bombero
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Bombero dado de Baja");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el Bombero con el ID especificado");
            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }

    }

    public void modificarBombero(Bombero bombero) {
//        UPDATE `bombero` SET `idBombero`='[value-1]',`dni`='[value-2]',`NombreApellido`='[value-3]'
//,`FechaNac`='[value-4]',`Celular`='[value-5]',`CodBrigada`='[value-6]' WHERE 1

        String sql = "UPDATE bombero SET NombreApellido=?, FechaNac=?, CodBrigada=?, dni=?,Celular=? ,grupoSanguineo=?"
                + "WHERE idBombero = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bombero.getNombreApellido());

            ps.setDate(2,Date.valueOf(bombero.getFechaNac()));
            ps.setInt(3, bombero.getBrigada().getCodBrigada());
            ps.setInt(4, bombero.getDni());
            ps.setString(5, bombero.getCelular());
            ps.setString(6, bombero.getGrupoSanguineo());
            ps.setInt(7, bombero.getIdBombero());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "bombero Modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    public Bombero buscarBombero(int id) {
//SELECT `dni``NombreApellido``FechaNac``Celular``CodBrigada` FROM `bombero` WHERE `idBombero`
        String sql = "SELECT NombreApellido, FechaNac, CodBrigada, dni,Celular,grupoSanguineo FROM bombero WHERE  idBombero = ? ";

        Bombero bombero = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                bombero = new Bombero();
                bombero.setIdBombero(id);
                bombero.setNombreApellido(rs.getString("NombreApellido"));
                bombero.setFechaNac(rs.getDate("FechaNac").toLocalDate());
                //  bombero.setCodBrigada(rs.getInt("codBrigada"));
                Brigada brigada = brid.buscarBrigada(rs.getInt("codBrigada"));
                bombero.setBrigada(brigada);
                bombero.setDni(rs.getInt("dni"));
                bombero.setCelular(rs.getString("celular"));
                bombero.setGrupoSanguineo(rs.getString("grupoSanguineo"));
            } else {

                JOptionPane.showMessageDialog(null, "Bombero no encontrado con ese ID");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }

        return bombero;
    }

   

    public ArrayList<Bombero> listarBomberos() {
        String sql = "SELECT idBombero, dni, NombreApellido, FechaNac, Celular,grupoSanguineo, CodBrigada FROM bombero WHERE idBombero != 0";
        ArrayList<Bombero> bombero = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bombero bomber = new Bombero();
                bomber.setIdBombero(rs.getByte("idBombero"));
                bomber.setDni(rs.getInt("dni"));
                bomber.setNombreApellido(rs.getNString("NombreApellido"));
                bomber.setFechaNac(rs.getDate("FechaNac").toLocalDate());
                bomber.setCelular(rs.getString("Celular"));
                 bomber.setGrupoSanguineo(rs.getString("grupoSanguineo"));
                bombero.add(bomber);
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Bombero");
        }
        return bombero;

    }
      public ArrayList<Bombero> listarBomberosXbrig(int cod) {
        String sql = "SELECT idBombero, dni, NombreApellido, FechaNac, Celular,grupoSanguineo FROM bombero WHERE CodBrigada=?";
        ArrayList<Bombero> bombero = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bombero bomber = new Bombero();
                bomber.setIdBombero(rs.getByte("idBombero"));
                bomber.setDni(rs.getInt("dni"));
                bomber.setNombreApellido(rs.getNString("NombreApellido"));
                bomber.setFechaNac(rs.getDate("FechaNac").toLocalDate());
                bomber.setCelular(rs.getString("Celular"));
                 bomber.setGrupoSanguineo(rs.getString("grupoSanguineo"));
                bombero.add(bomber);
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Bombero");
        }
        return bombero;

    }

}
