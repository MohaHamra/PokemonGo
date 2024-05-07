/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mabardaji
 */
public class Captura {
    private int id_coach;
    private int num_pokemon;
    private int CP;

    public Captura(int id_coach, int num_pokemon, int CP) {
        this.id_coach = id_coach;
        this.num_pokemon = num_pokemon;
        this.CP = CP;
    }

    public int getId_coach() {
        return id_coach;
    }

    public int getNum_pokemon() {
        return num_pokemon;
    }

    public int getCP() {
        return CP;
    }

    @Override
    public String toString() {
        return "Captura{" + "id_coach=" + id_coach + ", num_pokemon=" + num_pokemon + ", CP=" + CP + '}';
    }
    
    
    
    
}
