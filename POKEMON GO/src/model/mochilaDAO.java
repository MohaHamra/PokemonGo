/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Moha
 */
public class mochilaDAO {
    Connection conn;

    public mochilaDAO() throws SQLException {
        conn = DBConnect.getConnection();
    }
    
    public boolean darCaptura(int id_coach, int num_pokémon, int CP){
        mochila captura = new mochila();
        if(conn != null){
            String query = "INSERT INTO MOCHILA "
                    + "(ID_ENTRENADOR, NUM_POKEMON, CP) "
                    + "VALUES"
                    + "(?,?,?)";
            
            PreparedStatement prepared_query;
            try {
                prepared_query = conn.prepareStatement(query);
                prepared_query.setInt(1, captura.getId_coach());
                prepared_query.setInt(2, captura.getNum_pokémon());
                prepared_query.setInt(3, captura.getCP());
                if(prepared_query.executeUpdate() > 0){
                    return true;
                }
                else{
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
}
