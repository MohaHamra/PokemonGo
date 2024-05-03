/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import BD.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moha6340
 */
public class entrenadorDAO {
    Connection conn;

    public entrenadorDAO() throws SQLException {
        conn = DBConnect.getConnection(); 
    }
    
    public int altraEntrenador(entrenador ent) {
        int rows = 0;
        entrenador entr = new entrenador();
        if(conn != null){
            String query = "INSERT INTO ENTRENADOR "
                    + "(NAME, PASSWORD) "
                    + "VALUES"
                    + "(?,?)";
            
            System.out.println(query);
            PreparedStatement prepared_query;
            try {
                prepared_query = conn.prepareStatement(query);
                prepared_query.setString(1, entr.getName());
                prepared_query.setString(2, entr.getName());
                rows = prepared_query.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return rows;
    }
    
    public boolean exsisteixEntrenador(String name){
        try {
            conn = DBConnect.getConnection();
            entrenador ent = new entrenador();
            if (conn!=null)
            {
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * from entrenador where name = " + name;
                ResultSet res = stmt.executeQuery(query);
           
                int id = res.getInt("id");
                String nombre = res.getString("name");
                String password = res.getString("password");
                System.out.println(id + "-" + nombre + "-" + password);

                ent.setId(id);
                ent.setName(name);
                ent.setPassword(password);
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public entrenador borrarEntrenador(entrenador trainer){
        try {
            conn = DBConnect.getConnection();
            entrenador ent = new entrenador();
            int id = trainer.getId();
            if (conn!=null)
            {
                Statement stmt = conn.createStatement();
                
                String query = "DELETE from entrenador where id = " + id;
                PreparedStatement prepared_query;
                prepared_query = conn.prepareStatement(query);
                prepared_query.executeUpdate();
                
                return ent;
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

    public void totsEntrenadors() throws SQLException {
        Connection conn;
        int counter = 0;
            
        entrenador mostrar_entrenador = new entrenador();  
        conn = DBConnect.getConnection();     
        Statement stmt = conn.createStatement();        
        String query = "SELECT * from entrenadores";
        ResultSet cursor = stmt.executeQuery(query);
            
        while(cursor.next()){
            int id = cursor.getInt("id");
            String name = cursor.getString("nombre");
            String password = cursor.getString("password");
            System.out.println(id + "-" + name + "-" + password);
            
            mostrar_entrenador.setId(id);
            mostrar_entrenador.setName(name);
            mostrar_entrenador.setPassword(password);
            System.out.println(mostrar_entrenador);
            counter++;
        }
    }
    
    public entrenador devolverEntrenador(String name){
        try {
            conn = DBConnect.getConnection();
            entrenador ent = new entrenador();
            if (conn!=null)
            {
                Statement stmt = conn.createStatement();
                
                String query = "SELECT * from entrenador where name = " + name;
                ResultSet res = stmt.executeQuery(query);
           
                int id = res.getInt("id");
                String nombre = res.getString("name");
                String password = res.getString("password");
                System.out.println(id + "-" + nombre + "-" + password);

                ent.setId(id);
                ent.setName(name);
                ent.setPassword(password);
                return ent;
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
