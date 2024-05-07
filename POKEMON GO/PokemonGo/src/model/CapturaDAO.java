/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mabardaji
 */
public class CapturaDAO {
    //atribut per la conexió
    Connection conn_principal;

    public CapturaDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }    
    
    
    public boolean darCaptura(int id_coach, int num_pokemon, int CP) throws SQLException
    {
        int rows;
        if (conn_principal!=null)
        {
            String query = "INSERT INTO MOCHILA (id_entrenador,num_pokemon,CP) "
                    + " VALUES (?,?,?)";
            
            PreparedStatement stmt = conn_principal.prepareStatement(query);
            stmt.setInt(1, id_coach);
            stmt.setInt(2, num_pokemon);
            stmt.setInt(3, CP);
            
            rows = stmt.executeUpdate();
            if (rows>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }
        
        return false;
        
    }
    
    public List<Captura> getPokemonsCapturat(int id_coach) throws SQLException
    {
        List<Captura> mochila = new ArrayList<>();
        if (conn_principal!=null)
        {
            /*
            String query = "Select id_entrenador, num_pokemon, CP"
                    + "from mochila where id_entrenador = ?";
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setInt(1, id_coach);*/
            String query = "Select id_entrenador, num_pokemon, CP "
                    + "from mochila where id_entrenador = " + id_coach;
            
            Statement stmt = conn_principal.createStatement();
            ResultSet cursor = stmt.executeQuery(query);
            while (cursor.next())
            {
                int num_pokemon = cursor.getInt("num_pokemon");
                int CP = cursor.getInt("CP");
                Captura  capturada= new Captura(id_coach, num_pokemon, CP);
                mochila.add(capturada);
            }
        }
        return mochila;
    }

    public List<Captura> getPokemonsCapturatOrdenats(int id_coach) throws SQLException
    {
        List<Captura> mochila = new ArrayList<>();
        if (conn_principal!=null)
        {
            /*
            SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;
            String query = "Select id_entrenador, num_pokemon, CP"
                    + "from mochila where id_entrenador = ?";
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setInt(1, id_coach);*/
            String query = "Select id_entrenador, num_pokemon, CP, name "
                    + "from MOCHILA "
                    + "INNER JOIN POKEDEX ON MOCHILA.num_pokemon = POKEDEX.num "
                    + " where id_entrenador = " + id_coach
                    + " order by name ASC, CP DESC ";
            System.out.println(query);
            Statement stmt = conn_principal.createStatement();
            ResultSet cursor = stmt.executeQuery(query);
            while (cursor.next())
            {
                int num_pokemon = cursor.getInt("num_pokemon");
                int CP = cursor.getInt("CP");
                Captura  capturada= new Captura(id_coach, num_pokemon, CP);
                mochila.add(capturada);
            }
        }
        return mochila;
    }


    
}
