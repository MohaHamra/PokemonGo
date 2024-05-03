/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohah
 */
public class pokemonDAO {
    Connection conn;

    public pokemonDAO() throws SQLException {
        conn = DBConnect.getConnection(); 
    }
    
    public pokemon getPokemonRandom(){
        try {
            conn = DBConnect.getConnection();
            pokemon pok = new pokemon();
            if (conn!=null)
            {
                List<pokemon> lista_pokemons = devolverPokemons();
                int min = 1;
                int max = lista_pokemons.size();
                int range = (max - min) + 1;
                int random = (int)(Math.random() * range) + min;
                
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM pokedex where num = " + random + ";";
                ResultSet res = stmt.executeQuery(query);
           
                int num = res.getInt("num");
                String name = res.getString("name");
                String type = res.getString("type");

                pok.setNumero_pokedex(num);
                pok.setNombre(name);
                pok.setTipo(type);
                return pok;
            }
            else
            {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<pokemon> devolverPokemons(){
        try {
            Connection conn;
            conn = DBConnect.getConnection();
            List<pokemon> lista_pokemons = new ArrayList();
            pokemon pok;
            Statement stmt = conn.createStatement();
            String query = "SELECT * from pokedex";
            ResultSet cursor = stmt.executeQuery(query);
            
            while(cursor.next()){
                int num = cursor.getInt("num");
                String name = cursor.getString("name");
                String type = cursor.getString("type");
                pok = new pokemon(num, name, type);
                lista_pokemons.add(pok);
            }
            return lista_pokemons;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
