/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import fitxers.FicheroAscii;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mabardaji
 */
public class Pokemon {
    private int num_id;
    private String nombre;
    private String type;

    public Pokemon(int num_id, String nombre, String type) {
        this.num_id = num_id;
        this.nombre = nombre;
        this.type = type;
    }

    public int getNum_id() {
        return num_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getType() {
        return type;
    }

    public void setNum_id(int num_id) {
        this.num_id = num_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.nombre + " tipo " + this.type;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pokemon)) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        return this.num_id == other.num_id;
    }
    
    
    
    public List<String> mostrar_pokemon_ascii() throws FileNotFoundException, IOException
    {
        FicheroAscii pokemon_fichero = new FicheroAscii("pokemons/", this.nombre+".pok");
        List<String> lineas = pokemon_fichero.recuperarDatos();
        return lineas;
    }
    
    public int getFuerzaCombate()
    {
        Random rd = new Random();
        return rd.nextInt(100)+1;
    }
    
    
}
