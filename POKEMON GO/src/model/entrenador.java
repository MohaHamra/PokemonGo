/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author moha6340
 */
public class entrenador {
    private int id;
    private String name;
    private String password;

    public entrenador(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public entrenador(String name, String password) {
        this.name = name;
        this.password = password;
        this.id = 0;
    }

    public entrenador() {
    }

    public void setId(int id) {
        this.id = id;
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
        return "entrenador " + name + " con password = " + password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (!(obj instanceof entrenador)) {
            return false;
        }
        final entrenador other = (entrenador) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.name.equalsIgnoreCase(other.name);
    }
    
    
}
