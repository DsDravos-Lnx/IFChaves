/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Chave;


/**
 *
 * @author joaqu
 */
public class ChaveDAO { 
    
    public static void create(Chave chave) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Chaves (bloco,sala,status) VALUES (?,?,?)";

        try {

            stmt = dsn.prepareStatement(sql);

            stmt.setString(1, chave.getBloco());
            stmt.setString(2, chave.getSala());
            stmt.setString(3, chave.getStatus());

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Deu certo");
            } else {

                System.out.println("Deu errado");
            }

        } catch (SQLException e) {

            System.out.println("Deu errado");
            e.printStackTrace();

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

    }

    public static void update(Chave chave) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "UPDATE  Chaves SET bloco = ? , sala = ?, status = ?  WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setString(1, chave.getBloco());
            stmt.setString(2, chave.getSala());
            stmt.setString(3, chave.getStatus());
            stmt.setInt(4, chave.getId());

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Deu certo, Update1");
            } else {

                System.out.println("Deu errado, Update2");
            }

        } catch (SQLException e) {

            System.out.println("Deu errado, Update3");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

    }
    public int FindKey(String key){
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        
        String consultaSql = "SELECT * FROM Chaves WHERE id = ?";
        
        try{
            stmt = dsn.prepareStatement(consultaSql);
            stmt.setString(1, key);
            
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                if(resultado.getString(1).equals(key))
                    return resultado.getInt(1);
                }
            return 0;
        } catch(SQLException e){
            System.err.println("Deu Errado, FindKey!");
        }finally{
            conexao.desconextarComStatement(dsn, stmt);
        }
        return -1;
    }

        public static Chave ReturnKey(int id) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        Chave key = new Chave();
        String sql = "SELECT * FROM  Chaves WHERE id = ?";
        ResultSet rs = null;

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                key.setId(rs.getInt("id"));
                key.setBloco(rs.getString("bloco"));
                key.setSala(rs.getString("sala"));
                key.setStatus(rs.getString("status"));
                
            }

        } catch (SQLException e) {

            System.out.println("Deu errado, returnKey");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return key;

    }

    
    public List<Chave> ListarChaves() {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        List<Chave> Chaves = new ArrayList<>();
        String sql = "SELECT * FROM  Chaves  ORDER BY sala";
        ResultSet rs = null;

        try {

            stmt = dsn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Chave chave = new Chave();

                chave.setId(rs.getInt("id"));
                chave.setBloco(rs.getString("bloco"));
                chave.setSala(rs.getString("sala"));
                chave.setStatus(rs.getString("status"));

                Chaves.add(chave);

            }

        } catch (SQLException e) {

            System.out.println("Deu errado, ListarChaves");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return Chaves;

    }

    public void delete(Chave chave) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM  Chaves WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setInt(1, chave.getId());

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
