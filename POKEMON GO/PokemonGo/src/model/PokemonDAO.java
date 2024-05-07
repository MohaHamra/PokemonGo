/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import com.mysql.cj.jdbc.StatementImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mabardaji
 */
public class PokemonDAO {
//atribut per la conexió 
 //atribut per la conexió
    Connection conn_principal;

    public PokemonDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }    
    
    
    public List<Pokemon> getAllPokemons() throws SQLException
    {
        List<Pokemon> all_pokemon = null;
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            String query = "Select num,name,type"
                    + " from Pokedex";
            
            ResultSet cursor = stmt.executeQuery(query);
            all_pokemon = new ArrayList<>();
            while(cursor.next())
            {
                int num = cursor.getInt(1);
                String nom = cursor.getString("name");
                String contrasenya = cursor.getString("type");
                

                all_pokemon.add(new Pokemon(num, nom, contrasenya));
            }
             cursor.close();
        }
        return all_pokemon;        
    }
    
    public Pokemon getPokemonRandom() throws SQLException
    {
        List<Pokemon> all_pokemon = this.getAllPokemons();
        int max = all_pokemon.size();
        
        Random rd = new Random();
        int valor = rd.nextInt(max);
        
        return all_pokemon.get(valor);
        
    }
    
    public String getNombrePokemon(int num) throws SQLException
    {
        if (conn_principal!=null)
        {
            Statement stmt = conn_principal.createStatement();
            String query = "Select name"
                    + " from Pokedex where num = " + num;
            
            ResultSet cursor = stmt.executeQuery(query);
            if (cursor.next())
            {
                return cursor.getString(1);
            }
        }
        return null;
    }
    
    public List<Pokemon> pokemonsPorTipo(String tipo){
        List<Pokemon> lista;
        if(conn_principal != null){
            try {
                Statement stmt = conn_principal.createStatement();
                String query = "SELECT * FROM POKEDEX WHERE TYPE = '" + tipo + "';";
                ResultSet cursor = stmt.executeQuery(query);
                
                lista = new ArrayList<>();
                while(cursor.next()){
                    int num = cursor.getInt("num");
                    String name = cursor.getString("name");
                    String type = cursor.getString("type");
                    
                    lista.add(new Pokemon(num, name, type));
                }
                return lista;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
        return null;
    }
}
