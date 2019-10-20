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
import model.Usuario;


/**
 *
 * @author joaqu
 */
public class UsuarioDAO {

    public static void create(Usuario user) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Usuario (nome,matricula,email) VALUES (?,?,?)";

        try {

            stmt = dsn.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getMatricula());
            stmt.setString(3, user.getEmail());

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

    public static void update(Usuario user) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "UPDATE  Usuario SET nome = ? ,matricula = ?, email = ?  WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getMatricula());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getId());

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

    public static List<Usuario> ListarUsers() {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        List<Usuario> Users = new ArrayList<>();
        String sql = "SELECT * FROM  Usuario";
        ResultSet rs = null;

        try {

            stmt = dsn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setEmail(rs.getString("email"));

                Users.add(usuario);

            }

        } catch (SQLException e) {

            System.out.println("Deu errado");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return Users;

    }

    public static void delete(int id) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM  Usuario WHERE id = ?";

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setInt(1, id);

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
    
     public static Usuario returnUser(int id) {

        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;

        Usuario user = new Usuario();
        String sql = "SELECT * FROM  Usuario WHERE id = ?";
        ResultSet rs = null;

        try {

            stmt = dsn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setMatricula(rs.getString("matricula"));
                user.setEmail(rs.getString("email"));
                
            }

        } catch (SQLException e) {

            System.out.println("Deu errado, returnKey");

        } finally {

            conexao.desconextarComStatement(dsn, stmt);

        }

        return user;

    }

}
