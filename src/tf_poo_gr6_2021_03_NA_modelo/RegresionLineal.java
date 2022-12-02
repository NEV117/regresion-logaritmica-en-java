
package  tf_poo_gr6_2021_03_NA_modelo ;

// Subclase:

import java.text.DecimalFormat;
import java.util.ArrayList;
// Subclase:
public  class  RegresionLineal extends Regresion  {

    public RegresionLineal() {
        super();
    }
   

    @Override
    public double sumarAbscisas() {
        double totalSumAb = 0;
        
        for(Punto punt: puntos){
            totalSumAb += punt.getX();
        } //for    
        
        return totalSumAb;
    } // sumarAbscisas()

    @Override
    public double sumarOrdenadas() {
        double totalSumOrd = 0;
        
        for(Punto punt: puntos){
            totalSumOrd += punt.getY();
        } //for  
        
        return totalSumOrd;
    } //sumarOrdenadas()

    @Override
    public double sumarCuadradosDeAbscisas() {
        double totalSumAbCudrada = 0;
        
        for(Punto punt: puntos){
            totalSumAbCudrada += Math.pow(punt.getX(),2) ;
        } //for 
        
        return totalSumAbCudrada;
    } // sumarCuadradosDeAbscisas()

    @Override
    public double sumarProductosDeAbscisasConOrdenadas() {
        double SumPordAbOr = 0;
        
        for(Punto punt: puntos){
            SumPordAbOr += punt.getX() * punt.getY();
        } //for 
        
        return SumPordAbOr;
    } // sumarProductosDeAbscisasConOrdenadas()

    @Override
    public double abscisaPromedio() {
        double PromSumAb;
        
        PromSumAb = sumarAbscisas() /puntos.size();
                
        return PromSumAb; 
    } // abscisaPromedio()
        

    @Override
    public double ordenadaPromedio() {
        double PromSumOr = 0;       
        
        PromSumOr = sumarOrdenadas() /puntos.size();
        
        return PromSumOr;
    } //ordenadaPromedio()

    

    @Override
    public void calcularB() {
        double numerador = 0, denominador = 0 ;
        
        numerador = puntos.size() * sumarProductosDeAbscisasConOrdenadas()
                - sumarAbscisas() * sumarOrdenadas();
        
        denominador = puntos.size() * sumarCuadradosDeAbscisas() -
                Math.pow(sumarAbscisas(), 2) ;
        
        b = numerador/denominador; 
        
    } // calcularB()
    
    @Override
    public void calcularA() {        
        double numerador = 0, denominador = 0 ;
        
        numerador = puntos.size() * sumarProductosDeAbscisasConOrdenadas()
                - sumarAbscisas() * sumarOrdenadas();
        
        denominador = puntos.size() * sumarCuadradosDeAbscisas() -
                Math.pow(sumarAbscisas(), 2) ;
        
        b = numerador/denominador; 
        
        a = ordenadaPromedio() - b * abscisaPromedio();
        
    } //calcularA()

    @Override
    public double regresion(double x) {        
        return a + (b * x);       
    
    } //double regresion(double x)   

    @Override
    public String toString() {
        String ecuacion = "", constantes = "";
        ecuacion = "La ecuación de regresión Lineal es: y = " + df.format( super.a ) 
                    + " + " + df.format( super.b ) + "x" +"\n\n";
        constantes = "Constantes: " + "a = " + df.format( super.a ) 
                + "  b = " + df.format( super.b ) + "\n\n";        
        return ecuacion + constantes +  super.toString();
    }
    
    
} // Fin de la subclase RegresionLineal