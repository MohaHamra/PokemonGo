/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Moha
 */
public class mochila {
    private int id_coach;
    private int num_pokemon;
    private int CP;

    public mochila(int id_coach, int num_pokémon, int CP) {
        this.id_coach = id_coach;
        this.num_pokemon = num_pokémon;
        this.CP = CP;
    }

    public mochila() {
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public int getNum_pokémon() {
        return num_pokemon;
    }

    public void setNum_pokémon(int num_pokémon) {
        this.num_pokemon = num_pokémon;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    @Override
    public String toString() {
        return "Mochila: " + "id_coach=" + id_coach + ", numero pokemon=" + num_pokemon + ", CP=" + CP;
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
        if (!(obj instanceof mochila)) {
            return false;
        }
        final mochila other = (mochila) obj;
        if (this.id_coach != other.id_coach) {
            return false;
        }
        if (this.num_pokemon != other.num_pokemon) {
            return false;
        }
        return this.CP == other.CP;
    }
    
    
}
