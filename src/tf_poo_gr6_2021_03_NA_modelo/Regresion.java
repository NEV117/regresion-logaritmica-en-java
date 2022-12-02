
/**
 * 
 * POO, Grupo 6.
 * Regresiones: Lineal y Logarítmica.
 * Se utiliza el mecanismo de herencia de la POO.
 * 
 */

package tf_poo_gr6_2021_03_NA_modelo;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 *
 * Tarea Final de Programación Orientada a Objetos, Grupo 6.
 * Cali, octubre 26 de 2021.
 * @author 
 * 
 * Estudiante 1: Nicolas Escandon Varela
 * Código 1: 2205629
 * Estudiante 2:
 * Código 2:
 * Estudiante 3:
 * Código 3: 
 * 
 */

// Superclase ABSTRACTA:
public abstract class Regresion {
    // Atributos:
    protected ArrayList<Punto> puntos;
    protected ArrayList<Punto> puntosReg;
    // Para la Regresión Lineal, b es la pendiente y a es la ordenada en el origen.
    protected  double a, b ;
    protected  DecimalFormat  df ;

    //constructor
    public Regresion() {
        puntos = new ArrayList <> ();
        
        df = new DecimalFormat("0.0000");
    }
    
    //Getters
    public double getA() { return a;  }
    public double getB() { return b;  }
    
    //Seters
    public void setPuntos(ArrayList<Punto> puntos) { this.puntos = puntos; }
    public void setPuntosReg(ArrayList<Punto> puntosReg)
    { this.puntosReg = puntosReg; }
    
    
    
    //Metodo agregar punto al arreglo en el índice actual   
    public void agregarPuntos(Punto punt){
        if(punt == null)return;
        
        puntos.add(punt);
        
    } // agregarPuntos
    
    
    //Metodo agregar punto al arreglo en el índice actual   
    public void agregarPuntosReg(){
        puntosReg = new ArrayList <> ();
        double x, y;
        for(int i =0; i < puntos.size(); i++){
            x = puntos.get(i).getX();
            y = regresion(x);
            puntosReg.add(new Punto (x,y));
        }
        
        
    } // agregarPuntos
    
    //Ordenar puntos
    public void ordenarPuntosMuestra(){
        Punto auxi;
        double ordenada1, ordenada2;
        
        for(int i = 0; i < puntos.size()-1; i++){
            for(int j = 0; j < puntos.size()-1 -i; j++){
                ordenada1 = puntos.get(j).getY();
                ordenada2 = puntos.get(j + 1).getY();
                if(ordenada1 > ordenada2){
                    auxi = puntos.get(j);
                    puntos.set(j, puntos.get(j +1));
                }// if
            } // for
        } //for        
    }// ordenarPuntosMuestra()
    
    //Ordenar puntosReg
    public void ordenarPuntosReg(){
        Punto auxi;
        double absisa1, absisa2;
        
        for(int i = 0; i < puntosReg.size()-1; i++){
            for(int j = 0; j < puntosReg.size()-1 -i; j++){
                absisa1 = puntosReg.get(j).getX();
                absisa2 = puntosReg.get(j + 1).getX();
                if(absisa1 > absisa2){
                    auxi = puntosReg.get(j);
                    puntosReg.set(j, puntosReg.get(j +1));
                }// if
            } // for
        } //for        
    }// ordenarPuntosReg()
    
    @Override
    public String toString() {
        String reporte = "";        
        for(int i = 0; i < puntos.size(); i++){
            reporte += "Puntos Muestreados = " + puntos.get(i).toString() 
                + "\n";
        } //for               
        return reporte;
    }
    
    public String toString2() {
        String reporte2 = "";
        for(int i = 0; i < puntosReg.size(); i++){
            reporte2 += "Regresion" + "Puntos Ajustados = " + 
                    puntosReg.get(i).toString() + "\n";
        } // for
        return reporte2;
    }
    
          
        
    // Métodos abstractos:
    public  abstract  double  sumarAbscisas( ) ;
    public  abstract  double  sumarOrdenadas( ) ;
    public  abstract  double  sumarCuadradosDeAbscisas( ) ;
    public  abstract  double  sumarProductosDeAbscisasConOrdenadas( ) ;
    public  abstract  double  abscisaPromedio( ) ;
    public  abstract  double  ordenadaPromedio( ) ;
    public  abstract  void  calcularA();
    public  abstract  void  calcularB();
    
    // Método para estimar una ordenada con la Regresión seleccionada:
    public  abstract  double  regresion( double x ) ;
        
} // Fin de la superclase abstracta Regresion