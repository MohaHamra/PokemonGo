/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitxers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mabardaji logo.pok
 */
public class FicheroAscii {
    File ruta_archivo; //objecte file necessari
    FileReader reader; //
    BufferedReader fichero;
    
    //els 2 constructors  (un sense el boolean i el altre amb el boolean
    public FicheroAscii(String ruta, String nombre_fichero) throws FileNotFoundException
    {
        ruta_archivo = new File(ruta+nombre_fichero);
        reader = new FileReader(ruta_archivo);
        fichero = new BufferedReader(reader);
    }
    
    /**
     * 
     * @return linbea llegida o null si es final fitxer
     */
    public String leerLinea() throws IOException
    {
        return fichero.readLine();
    }
    //tancar el fitxer
    public void cerrarFicheros() throws IOException
    {
        reader.close();
        fichero.close();
    }
    
    

    
    /*recuperarDatos*/
    public List<String> recuperarDatos(/* */) throws IOException
    {
        List<String> Contenido = new ArrayList();
        String linea;
        
        do
        {
            linea = fichero.readLine();
            if (linea!=null)
            {
                Contenido.add(linea);
            }
        }while(linea!=null);
        this.cerrarFicheros();
        //abrir fichero
        //recuperar linea a linea y guardarlo en un arraylist<String>
        //retornar el arrayList<String>
        //no sout!!!
        return Contenido;
    }
    
}
