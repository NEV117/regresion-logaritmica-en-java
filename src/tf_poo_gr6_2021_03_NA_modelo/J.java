
/***********************************************************
 * J es una clase diseñada para abreviar la lectura e
 * impresión de datos ingresados desde el teclado. 
 * Elaborado por J. Antonio LemOs B. 
 * Cali, marzo 8 de 2005.
 * Última actualización: Cali, lunes 26 de abril de 2021.
 ********************************************************
*/

package tf_poo_gr6_2021_03_NA_modelo;

import  javax.swing.JOptionPane ;

public  final  class  J {
 	
    // Método que recibe una solicitud en msj y retorna una cadena de caracteres:
    public  static  String  leerCadena( String  msj ) {
        String  cadena;        
        do {
            cadena  =  JOptionPane.showInputDialog( msj ).trim() ;
            if( cadena.length( ) == 0 ) {
                String auxi = "DEBE DIGITAR UN TEXTO !!" ;
                System.out.println( auxi ) ;
                JOptionPane.showMessageDialog( null, auxi, msj, 0 ) ;
            }   // if  
        } while( cadena.length( ) == 0 ) ;        
        return  cadena ;
    }   // static  String  leerCadena(String)
    
    // Método que recibe una solicitud en msj y retorna un caracter:
    public  static  char  leerCaracter( String  msj ) {
        char  caracter  =  '\u0000' ;	// Caracter vacío = '\u0000'
        String strCaracter;
        do {
            // Primero lo captura como un String --> 
            strCaracter  =  JOptionPane.showInputDialog( msj ).trim() ;
            if( strCaracter.length( ) == 0 ) {
                String auxi = "DEBE DIGITAR UN CARACTER !!" ;
                System.out.println( auxi ) ;
                JOptionPane.showMessageDialog( null, auxi, msj, 0);
            }   // if  
        } while( strCaracter.length( ) == 0 ) ;
        
        caracter = strCaracter.charAt(0);
        
        return  caracter ;
    }   // static  char  leerCaracter(String)
    
    @SuppressWarnings("InfiniteRecursion")
    // Método que recibe una solicitud en msj y retorna un número entero:
    public static int leerEntero(String msj) {
        int entero;
        String strEntero = JOptionPane.showInputDialog(msj).trim();  
        try {
            entero = Integer.parseInt(strEntero);            
        }   // try
        catch(NumberFormatException nfe) {
            //System.out.println(nfe);
            System.out.println(nfe.getMessage());   
            String auxi = strEntero + " tiene un formato INVÁLIDO y NO se " + 
                "pudo convertir a número entero"; 
            System.out.println(auxi);
            JOptionPane.showMessageDialog( null, auxi, msj, 0);
            // RECURSIVIDAD:
            entero = leerEntero(msj);
        }   // catch
        return entero;
    }   // static int leerEntero(String)
    
    @SuppressWarnings("InfiniteRecursion")
    // Método que recibe una solicitud en msj y retorna un número real:
    public static double leerReal(String msj) {
        double real;
        String strReal = JOptionPane.showInputDialog(msj).trim();  
        try {
            real = Double.parseDouble(strReal);            
        }   // try
        catch(NumberFormatException nfe) {
            //System.out.println(nfe);
            System.out.println(nfe.getMessage());   
            String auxi = strReal + " tiene un formato INVÁLIDO y NO se " + 
                "pudo convertir a número real"; 
            System.out.println(auxi);
            JOptionPane.showMessageDialog( null, auxi, msj, 0);
            // RECURSIVIDAD:
            real = leerReal(msj);
        }   // catch
        return real;
    }   // static double leerReal(String)

    // Método que muestra la cadena str en consola:
    public  static  void  imprimir1( String  str ) {
        System.out.println( str ) ;        
    }
    
    // Método que muestra la cadena str en consola y en ventana emergente:
    public  static  void  imprimir2( String  str ) {
        System.out.println( str ) ;
        JOptionPane.showMessageDialog( null, str, 
            "REPORTE", JOptionPane.INFORMATION_MESSAGE ) ;
    }
 	
    // Sobrecargas del método imprimir1( ) para la impresión de
    // otro tipo de argumentos:
    // *********************** 
    public  static  void  imprimir1( ) {  imprimir1( "" ) ;  }

    public  static  void  imprimir1( char c ) {  imprimir1( "" + c ) ;  }

    public  static  void  imprimir1( int i ) {  imprimir1( "" + i ) ;  }

    public  static  void  imprimir1( double d ) {  imprimir1( "" + d ) ;  }

    public  static  void  imprimir1( boolean b ) {  imprimir1( "" + b ) ;  }
    
    // Sobrecargas del método imprimir2( ) para la impresión de
    // otro tipo de argumentos:
    // ***********************
    public  static  void  imprimir2( ) {  imprimir2( "" ) ;  }

    public  static  void  imprimir2( char c ) {  imprimir2( "" + c ) ;  }

    public  static  void  imprimir2( int i ) {  imprimir2( "" + i ) ;  }

    public  static  void  imprimir2( double d ) {  imprimir2( "" + d ) ;  }

    public  static  void  imprimir2( boolean b ) {  imprimir2( "" + b ) ;  }
 	
 }