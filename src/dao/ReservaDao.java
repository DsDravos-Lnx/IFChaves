/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Reserva;
import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author joaqu
 */
public class ReservaDao {
    
    
    public static void create (Reserva reserva){
        
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO Reservas (dia_inicio,hora_inicio,nome_user,nome_admin"
                + "chave_sala,dia_encerramento,hora_encerramento,chave_id, user_id,admin_id) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        
        
        try {

            stmt = dsn.prepareStatement(sql);

            stmt.setString(1, reserva.getDia_inicio());
            stmt.setString(2, reserva.getHora_inicio());
            stmt.setString(3, reserva.getNome_user());
            stmt.setString(4, reserva.getNome_admin());
            stmt.setString(5, reserva.getChave_sala()); 
            stmt.setString(6, reserva.getDia_encerra());
            stmt.setString(7, reserva.getHora_encerra());
            stmt.setInt(8, reserva.getChave_id()); 
            stmt.setInt(9, reserva.getUser_id());
            stmt.setInt(10, reserva.getAdmin_id());
            
            

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Deu certo");
            } else {

                System.out.println("Deu errado");
            }

        } catch (SQLException e) {

            System.out.println("Deu errado");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }


        
        
    }
    
}
