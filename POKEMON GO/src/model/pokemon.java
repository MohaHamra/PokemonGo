/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author mohah
 */
public class pokemon {
    private int numero_pokedex;
    private String nombre;
    private String tipo;

    public pokemon(int numero_pokedex, String nombre, String tipo) {
        this.numero_pokedex = numero_pokedex;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public pokemon() {
    }

    public int getNumero_pokedex() {
        return numero_pokedex;
    }

    public void setNumero_pokedex(int numero_pokedex) {
        this.numero_pokedex = numero_pokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " tipo " + tipo + " con numero pokedex" + numero_pokedex;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof pokemon)) {
            return false;
        }
        final pokemon other = (pokemon) obj;
        if (this.numero_pokedex != other.numero_pokedex) {
            return false;
        }
        return this.nombre.equalsIgnoreCase(other.nombre);
    }
    
}
