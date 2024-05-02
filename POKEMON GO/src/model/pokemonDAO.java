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
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * FROM tu_tabla ORDER BY RAND() LIMIT 1;";
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
}
