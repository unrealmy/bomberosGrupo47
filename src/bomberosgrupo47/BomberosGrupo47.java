/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo47;

import bomberosgrupo47.accesoADatos.BomberoData;
import bomberosgrupo47.accesoADatos.BrigadaData;
import bomberosgrupo47.accesoADatos.CuartelData;
import bomberosgrupo47.accesoADatos.SiniestroData;
import bomberosgrupo47.entidades.Bombero;
import bomberosgrupo47.entidades.Brigada;
import bomberosgrupo47.entidades.Cuartel;
import bomberosgrupo47.entidades.Siniestro;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class BomberosGrupo47 {

    
    public static void main(String[] args) {
        // TODO code application logic here
//        Cuartel cuar=new Cuartel(1,"llamaMoto","falsa123",123,121,"0303456","no tiene");
//        CuartelData cuda=new CuartelData();
//        System.out.println(cuda.buscarCuartel(1).toString());
//        cuda.modificarCuartel(cuar);
//        cuda.guardarCuartel(cuar);
//        
//        Brigada bri=new Brigada("alfa2","fire",true,cuar);
//          BrigadaData briD=new BrigadaData();
//        briD.guardarBrigada(bri);
//          System.out.println(briD.buscarBrigada(5).toString());
//       
//        BomberoData un=new BomberoData();
//        Bombero bom=new Bombero(123,"llama",Date.valueOf(LocalDate.of(1990, 4, 23)),"12313",bri);
//        un.guardarBombero(bom);
// String tipo, Date FechaSiniestro, int CoordX, int CoordY, String Detalles, Date FechaResol, int Puntuacion, Brigada brigada
//         Siniestro lare=new Siniestro("reptil",Date.valueOf(LocalDate.of(2022, 4, 23)),231,123,"d",Date.valueOf(LocalDate.of(2022, 4, 23)),7,bri);
//         SiniestroData m1=new SiniestroData();
//         m1.guardarSiniestro(lare);

//BomberoData bom2=new BomberoData();
//Brigada bri=new Brigada();
//bri=briD.buscarBrigada(5);
//Bombero bom=new Bombero(1,123,"llama saka",Date.valueOf(LocalDate.of(1990, 4, 23)),"123",bri);
////bom2.modificarBombero(bom);
//System.out.println(bom2.buscarBombero(1));

//CuartelData da=new CuartelData();
//Cuartel cua=new Cuartel();
//cua=da.buscarCuartel(1);
//        System.out.println(cua.toString());

//        ArrayList<Cuartel> Cuarteles = da.listarcuartel();
//        Iterator<Cuartel> Iterator2 = Cuarteles.iterator();
//        while (Iterator2.hasNext()) {
//            Cuartel elemento = Iterator2.next();
//            System.out.print(elemento.toString());
//
//        }

BrigadaData d=new BrigadaData();
        System.out.println("s"+d.BrigadaEspacio(5));

        
    }
    
}
