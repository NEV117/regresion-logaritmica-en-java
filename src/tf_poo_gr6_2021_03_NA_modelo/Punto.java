
package tf_poo_gr6_2021_03_NA_modelo;

import java.text.DecimalFormat;

/**
 *
 * Tarea Final de Programación Orientada a Objetos.
 * Cali, octubre 26 de 2021.
 * @author Prof. J. Antonio LemOs B.
 * 
 */

public class Punto {
    // Atributos:
    private double x;
    private double y;
    private  DecimalFormat  df ;
    
    // Constructor de los objetos de la clase:
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        df  =  new  DecimalFormat( "0.0000" ) ;
    }   // Constructor

    // Métodos de consulta (Getters):
    public double getX() {  return x;  }
    public double getY() {  return y;  }

    // Métodos modificadores (Setters):
    public void setX(double x) {  this.x = x;  }
    public void setY(double y) {  this.y = y;  }
    
    // Método que construye un reporte con el estado del objeto; es decir, con
    // los valores ACTUALES de sus atributos:
    @Override
    public String toString() {
        return "(" + df.format(x) + ", " + df.format(y) + ")";   
    }      
    
    // Métodos:
    public double calcularDistancia() {
        /*double distancia;
        distancia = Math.sqrt(x*x + y*y);
        distancia = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distancia;*/
        return Math.sqrt(x*x + y*y); 
    }   // double calcularDistancia() 
    
    // Método que determina y retorna el cuadrante del
    // punto actual:
    public int obtenerCuadrante(){
        int cuadrante;
        if(x > 0 && y > 0) {
            cuadrante = 1;
        }
        else if(x < 0 && y > 0) {
            cuadrante = 2;
        }
        else if(x < 0 && y < 0) {
            cuadrante = 3;
        }
        else if(x > 0 && y < 0) {
            cuadrante = 4;
        }
        else {
           cuadrante = 0; // Significa que está en alguno de los ejes. 
        }
        return cuadrante;
    }   // obtenerCuadrante() 
    
    // Método que calcula y retorna la distancia desde el punto actual
    // hasta el punto (xDeOtro, yDeOtro):
    public double distanciaHasta(double xDeOtro, double yDeOtro) {
        double dx, dy, d;
        dx = xDeOtro - this.x;
        dy = yDeOtro - this.y;
        d = Math.sqrt(dx*dx + dy*dy);
        return d;
    } // double distanciaHasta( ... )
    
}   // class Punto