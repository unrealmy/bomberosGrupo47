/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47.Vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import javax.swing.SwingUtilities;
public class Raton extends MouseAdapter {
    private Point posicion;
    
    
    public Raton(Component sd){
    posicion=new Point();
    actualizarPosicion(sd);
    }
    public void actualizar(Component sd){
    actualizarPosicion(sd);
    }
    public void dibujar(Graphics g){
    g.setColor(Color.red);
    g.drawString("X: "+ obtenerPo().getX(), 10, 10);
    g.drawString("y: "+ obtenerPo().getY(), 10, 20);
    }
    public void obtenex(){
    double x=obtenerPo().getX();
    }
    
    private void actualizarPosicion(Component sd){
//        arg0  getPointerInfo().getLocation()
       
    Point posicionInicial=MouseInfo.getPointerInfo().getLocation();
    
    SwingUtilities.convertPointFromScreen(posicionInicial, sd);
    posicion.setLocation(posicionInicial.getX(),posicionInicial.getY());
    
    }
   public Point obtenerPo(){
   return posicion;
   }
}