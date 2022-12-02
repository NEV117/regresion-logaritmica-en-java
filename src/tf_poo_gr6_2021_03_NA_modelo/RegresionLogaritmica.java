
package tf_poo_gr6_2021_03_NA_modelo;

// Subclase:

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RegresionLogaritmica extends Regresion {

    public RegresionLogaritmica() {
        super();
    }
    
    

    @Override
    public double sumarAbscisas() {
        double totalSumUx = 0;
        
        for(Punto punt: puntos){            
            totalSumUx += (Math.log(punt.getX()));
        } //for    
        
        return totalSumUx;
    }

    @Override
    public double sumarOrdenadas() {
        double totalSumUy = 0;
        
        for(Punto punt: puntos){
            totalSumUy += punt.getY();
        } //for  
        
        return totalSumUy;
        
    }

    @Override
    public double sumarCuadradosDeAbscisas() {
        double totalSumUxCudrada = 0;
        
        for(Punto punt: puntos){
            totalSumUxCudrada += Math.pow(Math.log(punt.getX()), 2) ;
        } //for 
        
        return totalSumUxCudrada;
        
    }

    @Override
    public double sumarProductosDeAbscisasConOrdenadas() {
        double SumPordUxUy = 0;
        
        for(Punto punt: puntos){
            SumPordUxUy += (Math.log(punt.getX()) * punt.getY());
        } //for 
        
        return SumPordUxUy;
        
    }

    @Override
    public double abscisaPromedio() {        
        double PromSumUx = 0;
        
        PromSumUx = sumarAbscisas() /puntos.size();  
                        
        return PromSumUx;
    }

    @Override
    public double ordenadaPromedio() {
        double PromSumUy = 0;        
         
        PromSumUy = sumarOrdenadas() /puntos.size();
        
        return PromSumUy;
        
    }

    @Override
    public void calcularA() {
        double  Y = 0, U = 0, numerador = 0, denominador = 0 ;
        
        numerador = puntos.size() * sumarProductosDeAbscisasConOrdenadas()
                - sumarAbscisas() * sumarOrdenadas();
        
        denominador = puntos.size() * sumarCuadradosDeAbscisas() -
                Math.pow(sumarAbscisas(), 2) ;
        
        b = numerador/denominador;  
                
        Y = ordenadaPromedio();
        U = abscisaPromedio();
                        
        a = Y - (b * U);         
    }

    @Override
    public void calcularB() {
        double numerador = 0, denominador = 0 ;
        
        numerador = puntos.size() * sumarProductosDeAbscisasConOrdenadas()
                - sumarAbscisas() * sumarOrdenadas()  ;
        
        denominador = puntos.size() * sumarCuadradosDeAbscisas() -
                Math.pow(sumarAbscisas(), 2) ;
        
        b = numerador/denominador;        
    }

    @Override
    public double regresion(double x) {
        double p = 0, q = 0;        
        p = a;
        q = b;                
        return p + (q * Math.log(x));        
    }

    @Override
    public String toString() {
        String ecuacion = "", constantes = "";
        ecuacion = "La ecuación de regresión Logaritmica es: y = " + df.format( super.a ) 
                    + " + " + df.format( super.b ) + "Ln(x)" +"\n\n";
        constantes = "Constantes: " + "p = " + df.format( super.a ) 
                + "  q = " + df.format( super.b ) + "\n\n";        
        return ecuacion + constantes +  super.toString();
    }
    
    
} // Fin de la subclase RegresionLogaritmica