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
import model.Emprestimo;
import model.Usuario;
import dao.ChaveDAO;

/**
 *
 * @author joaquim
 */
public class EmprestimoDAO {

    public static void create(Emprestimo emprestimo) {
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO emprestimo (chave_id,user_id,data,hora,nome_user,status,chave_sala,adm,"
                + "data_devolu,hora_devolu) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            stmt = dsn.prepareStatement(sql);
            
            stmt.setInt(1, emprestimo.getChave_id());
            stmt.setInt(2, emprestimo.getUser_id());
            stmt.setString(3, emprestimo.getData());
            stmt.setString(4, emprestimo.getHora());
            stmt.setString(5, emprestimo.getNome_user());
            stmt.setString(6, emprestimo.getStatus());
            stmt.setString(7, emprestimo.getChave_sala());
            stmt.setString(8, emprestimo.getAdm());
            stmt.setString(9, emprestimo.getData_devolu());
            stmt.setString(10, emprestimo.getHora_devolu());
            
            
            
            

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Emprestimo realiazado com sucesso");
            } else {

                System.out.println("Deu errado no update");
            }

        } catch (SQLException e) {

            System.out.println("Deu errado no sql");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

    }

    public static void updateChaveEmprestada(Chave chave) {
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        chave.setStatus("Emprestada");
        
        String sql = "UPDATE  Chaves SET status = ?  WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setString(1, chave.getStatus());
            stmt.setInt(2, chave.getId());
            

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Deu certo update status chave");
            } else {

                System.out.println("Deu errado update status chave 2");
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

    }
    
    public static List<Emprestimo> listarEmprestimos(){
        
         Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        List<Emprestimo> emprestimo = new ArrayList<>();
        String sql = "SELECT * FROM  emprestimo  WHERE status = 'Ativo' ORDER BY data DESC, hora DESC";
        ResultSet rs = null;

        try {

            stmt = dsn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emp = new Emprestimo();
                emp.setId(rs.getInt("id"));
                emp.setChave_id(rs.getInt("chave_id"));
                emp.setUser_id(rs.getInt("user_id"));
                emp.setData(rs.getString("data"));
                emp.setHora(rs.getString("hora"));
                emp.setNome_user(rs.getString("nome_user"));
                emp.setStatus(rs.getString("status"));
                emp.setChave_sala(rs.getString("chave_sala"));
                emp.setAdm(rs.getString("adm"));
                emp.setData_devolu(rs.getString("data_devolu"));
                emp.setHora_devolu(rs.getString("hora_devolu"));
                
                emprestimo.add(emp);

              

            }

        } catch (SQLException e) {

            System.out.println("Deu errado");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return emprestimo;
        
       
    }
    
    
        public static List<Emprestimo> listarRelatorio(){
        
         Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        List<Emprestimo> emprestimo = new ArrayList<>();
        String sql = "SELECT * FROM  emprestimo ORDER BY data DESC, hora DESC";
        ResultSet rs = null;

        try {

            stmt = dsn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emp = new Emprestimo();
                emp.setId(rs.getInt("id"));
                emp.setChave_id(rs.getInt("chave_id"));
                emp.setUser_id(rs.getInt("user_id"));
                emp.setData(rs.getString("data"));
                emp.setHora(rs.getString("hora"));
                emp.setNome_user(rs.getString("nome_user"));
                emp.setStatus(rs.getString("status"));
                emp.setChave_sala(rs.getString("chave_sala"));
                emp.setAdm(rs.getString("adm"));
                emp.setData_devolu(rs.getString("data_devolu"));
                emp.setHora_devolu(rs.getString("hora_devolu"));
                
                emprestimo.add(emp);

              

            }

        } catch (SQLException e) {

            System.out.println("Deu errado");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return emprestimo;
        
       
    }

     public static Emprestimo findEmprestimos(int id){
        
         Connection dsn = conexao.getconnectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
        Emprestimo emp = new Emprestimo();
        String sql = "SELECT * FROM  emprestimo  WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

              
                emp.setId(rs.getInt("id"));
                emp.setChave_id(rs.getInt("chave_id"));
                emp.setUser_id(rs.getInt("user_id"));
                emp.setData(rs.getString("data"));
                emp.setHora(rs.getString("hora"));
                emp.setNome_user(rs.getString("nome_user"));
                emp.setStatus(rs.getString("status"));
                emp.setChave_sala(rs.getString("chave_sala"));
                emp.setAdm(rs.getString("adm"));
                emp.setData_devolu(rs.getString("data_devolu"));
                emp.setHora_devolu(rs.getString("hora_devolu"));
            }

        } catch (SQLException e) {

            System.out.println("Deu errado a busca");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return emp;
        
       
    }
     
     public static void updateEmprestimo(Emprestimo emprestimo) {
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        
        
        String sql = "UPDATE  emprestimo SET status = ?, data_devolu = ?, hora_devolu = ? WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setString(1, emprestimo.getStatus());
            stmt.setString(2, emprestimo.getData_devolu());
            stmt.setString(3, emprestimo.getHora_devolu());
            stmt.setInt(4, emprestimo.getId());
          

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Deu certo update status emprestimo");
                updateChaveDevolvida(emprestimo.getChave_id());
                
            } else {

                System.out.println("Deu errado update status emprestimo 2");
            }

        } catch (SQLException e) {

            System.out.println("Deu errado, update status emprestimo 3");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

    }
     
     public static void updateChaveDevolvida(int id) {
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        
        
        String sql = "UPDATE  Chaves SET status = ?  WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setString(1, "Disponivel");
            stmt.setInt(2, id);
            

            int resultado = stmt.executeUpdate();

            if (resultado == 1) {

                System.out.println("Deu certo update status chave");
            } else {

                System.out.println("Deu errado update status chave 2");
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

    }
     
      public static String dateEmprestimo() {
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
         ResultSet rs = null;
           String resultado = null;
        
        String sql = "SELECT COUNT (status) FROM emprestimo  WHERE status = ? ";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setString(1, "Ativo");
            rs = stmt.executeQuery();

            while (rs.next()) {

               resultado = rs.getString(1);
               
             
            }
            
            

        } catch (SQLException e) {

            System.out.println("Deu errado a busca");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }
        
         return resultado;

}

}