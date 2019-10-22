/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joaqu
 */
public class conexao { 
    
    private static Connection conexão = null;
    private static final String dsn = "jdbc:sqlite:Banco_Dados/banco_de_dados.db";
    
    
        public static Connection getconnectar() {

        if (conexão == null) {

            try {
                   Class.forName("org.sqlite.JDBC");
                conexão = DriverManager.getConnection(dsn);

            } catch (Exception e) {

                System.out.println("Erro ao conectar");
                e.printStackTrace();
                

            }

            System.out.println("Conectou meu garoto (getconnectar)");

        }

        return conexão;

    }

    public static boolean desconectar(Connection con) {

        try {

            if (con != null) {

                con.close();
                conexão = null;
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return false;

        }
        System.out.println("Desconectou meu garoto (desconectar)");

        return true;
    }

    public static void desconextarComStatement(Connection con, PreparedStatement stmt) {

        desconectar(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
           System.out.println("Deu certo meu garoto (statment)");
    }

    public static void desconextarComStatementEtbResultSet(Connection con, PreparedStatement stmt, ResultSet rs) {

        desconextarComStatement(con, stmt);

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
         System.out.println("Deu certo meu garoto (resultSet)");
    }
    
}
