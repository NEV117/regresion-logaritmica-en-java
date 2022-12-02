
package tf_poo_gr6_2021_03_NA_modelo;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

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

public class Main {

    @SuppressWarnings("null")
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000");          
        char hayPuntos;
        // Declaración de referencias de las clases usadas:
        Regresion reg = null;
        boolean primeraVez = true;
        Punto punt;
        
        
        do {
            hayPuntos = J.leerCaracter("¿Hay puntos para registrar? [S/N]: ");
            hayPuntos = ("" + hayPuntos).toUpperCase().charAt(0);
        } while( hayPuntos != 'S' && hayPuntos != 'N' );
        
        if(hayPuntos == 'N') System.exit(0); // FINALICE el programa.        
        
        // CICLO para obtener y registrar los puntos de la muestra:
        while(hayPuntos == 'S') {
            
            if(primeraVez) {
                reg = Main.seleccionarRegresion();
                primeraVez = false;
            }   // if
            
            // Obtener el punto de la muestra y guardarlo en un arreglo:            
            reg.agregarPuntos(crearPunto());
            
            do {
                hayPuntos = J.leerCaracter("¿Hay MÁS puntos de la muestra para "
                    + "registrar? [S/N]: ");
                hayPuntos = ("" + hayPuntos).toUpperCase().charAt(0);
                //} while( !(hayPuntos == 'S' || hayPuntos == 'N') );
            } while( hayPuntos != 'S' && hayPuntos != 'N' );
        }   // while
        reg.calcularA();
        reg.calcularB();          
        J.imprimir1(reg.toString());
        
        reg.agregarPuntosReg();        
        J.imprimir1(reg.toString2());
        
        
    }   // main
    
    // Método interno que crea un punto de la muestra y retorna su referencia:  
    private static Punto crearPunto() {
        // Variables locales:
        double x;  // Abscisa (o primera coordenada) del punto.
        double y;  // Ordenada (o segunda coordenada) del punto.
        x = J.leerReal("Digite la abscisa (o primera coordenada) del punto: ");
        y = J.leerReal("Digite la ordenada (o segunda coordenada) del punto: ");
        return new Punto(x, y);              
        
    }   // private static Punto crearPunto()
    
    //
    private static Regresion seleccionarRegresion() {
        Regresion reg = null;
        int tipoRegresion;
        String msjError;
        String msj = "Seleccione el Tipo de Regresión que va a usar, así:\n 1 " 
            + "para REGRESIÓN LINEAL\n 2 para REGRESIÓN LOGARÍTMICA\n 3 para "
            + "REGRESIÓN EXPONENCIAL\n 4 para REGRESIÓN POTENCIAL\n  5 para "
            + "REGRESIÓN INVERSA\n Digite su Opción: ";        
        do {
            tipoRegresion = J.leerEntero(msj);
            if(tipoRegresion < 1 || tipoRegresion > 5) {
                msjError = tipoRegresion + " es un valor INVÁLIDO, pues "
                    + "DEBE ser un número entero desde 1 hasta 5"; 
                J.imprimir2(msjError);                
            }
        } while(tipoRegresion < 1 || tipoRegresion > 5);
                        
        if(tipoRegresion == 1) {
            reg = Main.crearRegresionLineal();            
        }
        else if(tipoRegresion == 2) {
            reg = Main.crearRegresionLogaritmica();
            
        }
        else if(tipoRegresion == 3) {
            J.imprimir2("Regresión Pendiente: EN CONSTRUCCIÓN");
            System.exit(0);               
        }
        else if(tipoRegresion == 4) {
            J.imprimir2("Regresión Pendiente: EN CONSTRUCCIÓN");
            System.exit(0);                
        }
        else {
            J.imprimir2("Regresión Pendiente: EN CONSTRUCCIÓN");
            System.exit(0);  
        }        
        return reg;        
    }   // seleccionarRegresion()
    
    private static RegresionLineal crearRegresionLineal(){        
        RegresionLineal RegL = null;
        RegL = new RegresionLineal();        
        return RegL;
    } //crearRegresionLineal()
    
    private static RegresionLogaritmica crearRegresionLogaritmica(){        
        RegresionLogaritmica RegLog = null;
        RegLog = new RegresionLogaritmica();        
        return RegLog;
    } //crearRegresionLogaritmica()
    
}   // Main