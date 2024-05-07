/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author mabardaji
 */
public class Entrenador {
    private int id;
    private String name;
    private String password;

    public Entrenador(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Entrenador(String name, String password) {
        this.id = 0;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "El entrenador " + name + " tiene el password " + password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Entrenador)) {
            return false;
        }
        final Entrenador other = (Entrenador) obj;
        
        return this.name.equalsIgnoreCase(other.name);
    }
    
    
    
}
