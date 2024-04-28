/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moha
 */
public class FitxerCaratula {
    private String ruta;
    
    public FitxerCaratula(String ruta) {
        this.ruta = ruta;
    }

    public List<String> cargarCaratula() throws IOException {
        List<String> contenido = new ArrayList<>();

        FileReader archivo = new FileReader(ruta);
        BufferedReader reader = new BufferedReader(archivo);
        
        String linea;
        while ((linea = reader.readLine()) != null) {
            contenido.add(linea);
        }
        return contenido;
    }

}
