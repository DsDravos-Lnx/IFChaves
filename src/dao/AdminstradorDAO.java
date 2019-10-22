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
import model.Administrador;

/**
 *
 * @author joaqu
 */
public class AdminstradorDAO {
    
    
    public void create (Administrador adm){
        
         Connection dsn = conexao.getconnectar();
         PreparedStatement stmt = null;
         
         String sql = "INSERT INTO Administrador (nome,email,usuario,senha) VALUES (?,?,?,?)";
         
         
            try {
             
             stmt =  dsn.prepareStatement(sql);
             
             stmt.setString(1, adm.getNome());
             stmt.setString(2, adm.getEmail());
             stmt.setString(3, adm.getUsuario());
             stmt.setString(4, adm.getSenha());
             
             int resultado =  stmt.executeUpdate();
             
            if(resultado == 1){
                
                System.out.println("Deu certo");
            }else{
                
                System.out.println("Deu errado");
            }
          
        }catch(SQLException e){
            
             System.out.println("Deu errado");
            
            
            
        }finally{
             
         conexao.desconextarComStatement(dsn, stmt);
          

        }
          
        
    }
    
    
    public void update(Administrador adm){
        
         Connection dsn = conexao.getconnectar();
         PreparedStatement stmt = null;
         
         
        String sql = "UPDATE  Administrador SET nome = ? ,email = ?,usuario = ?, senha = ? WHERE id = ?";
        
       try {
             
             stmt =  dsn.prepareStatement(sql);
             stmt.setString(1,adm.getNome() );
             stmt.setString(2,adm.getEmail());
             stmt.setString(3, adm.getUsuario());
             stmt.setString(4, adm.getSenha());
             stmt.setInt(5, adm.getId());
              
             int resultado =  stmt.executeUpdate();
             
            if(resultado == 1){
                
                System.out.println("Deu certo");
            }else{
                
                System.out.println("Deu errado");
            }
          
        }catch(SQLException e){
            
             System.out.println("Deu errado");
            
            
            
        }finally{
             
         conexao.desconextarComStatement(dsn, stmt);
          
          
         }
       
        
    }
    
    public int CheckLogin(String user, String pass){
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        
        String consultaSql = "SELECT * FROM Administrador WHERE usuario = ? AND senha = ?";
        
        try{
            stmt =  dsn.prepareStatement(consultaSql);
            stmt.setString(1, user);            
            stmt.setString(2, pass);
            
            ResultSet resultado =  stmt.executeQuery();
            
            while(resultado.next()){
                if(resultado.getString(4).equals(user) && resultado.getString(5).equals(pass)){
                 Administrador administrador = new Administrador();
                 
                 administrador.setId(resultado.getInt("id"));
                 administrador.setNome(resultado.getString("nome"));
                 administrador.setEmail(resultado.getString("email"));
                 administrador.setUsuario(resultado.getString("usuario"));
                 administrador.setSenha(resultado.getString("senha"));  
                 IfcechavesFX.IfcechavesFX.admLogado = administrador;
                //System.out.println(IfcechavesFX.IfcechavesFX.admLogado.getNome());
            

                    return 1;
                }    
            }
            return 0;

        } catch (SQLException e) {
            System.err.println("Deu Errado!");
        }finally{
            conexao.desconextarComStatement(dsn, stmt);
         }
        return -1;
        
    }
    
        public int CheckUser(String user){
        Connection dsn = conexao.getconnectar();
        PreparedStatement stmt = null;
        
        String consultaSql = "SELECT * FROM Administrador WHERE usuario = ?";
        
        try{
            stmt =  dsn.prepareStatement(consultaSql);
            stmt.setString(1, user);           
            
            ResultSet resultado =  stmt.executeQuery();
            while(resultado.next()){
                if(resultado.getString(4).equals(user)){
                      Administrador administrador = new Administrador();
                 
                 administrador.setId(resultado.getInt("id"));
                 administrador.setNome(resultado.getString("nome"));
                 administrador.setEmail(resultado.getString("email"));
                 administrador.setUsuario(resultado.getString("usuario"));
                 administrador.setSenha(resultado.getString("senha"));
                
                 
                    return 1;
                }
               
                    
                
            }
            return 0;

            
        } catch (SQLException e) {
            System.err.println("Deu Errado!");
        }finally{
            conexao.desconextarComStatement(dsn, stmt);
         }
        return -1;
        
    }
        
        
    
    public static List <Administrador> ListarAdms(){
        
         Connection dsn = conexao.getconnectar();
         PreparedStatement stmt = null;
         
         
          List <Administrador> Adms = new ArrayList<>();
          String sql = "SELECT * FROM  Administrador";
          ResultSet rs = null;
          
         try {
             
             stmt =  dsn.prepareStatement(sql);
             rs = stmt.executeQuery();
          
        
             
            while (rs.next()) {

                 Administrador administrador = new Administrador();
                 
                 administrador.setId(rs.getInt("id"));
                 administrador.setNome(rs.getString("nome"));
                 administrador.setEmail(rs.getString("email"));
                 administrador.setUsuario(rs.getString("usuario"));
                 administrador.setSenha(rs.getString("senha"));
                 Adms.add(administrador);
                 

                 
               
            }
          
        }catch(SQLException e){
            
             System.out.println("Deu errado");
            
            
            
        }finally{
             
              conexao.desconextarComStatement(dsn, stmt);
          
         }

          
     return Adms;
        
        
    }
    
    public static void delete(int id){
        
         Connection dsn = conexao.getconnectar();
         PreparedStatement stmt = null;
         
         
           String sql = "DELETE FROM  Administrador WHERE id = ?";
         
            try {
             
             stmt =  dsn.prepareStatement(sql);
             stmt.setInt(1, id);
        
             int resultado =  stmt.executeUpdate();
             
            if(resultado == 1){
                
                System.out.println("Deu certo");
            }else{
                
                System.out.println("Deu errado");
            }
          
        }catch(SQLException e){
            
             System.out.println("Deu errado");
            
            
            
        }finally{
             
              conexao.desconextarComStatement(dsn, stmt);
              
          
         }
        

        
        
    }
    
    
}
