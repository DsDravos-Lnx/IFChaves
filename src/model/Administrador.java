/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joaqu
 */
public class Administrador {
    
    private int id;
    private String nome;
    private String email;
    private String usuario;
    private String senha;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome =  validarNome(nome);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validarEmail(email);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    private static String validarNome(String nome) {

        if (nome.isEmpty() || nome.length() < 3) {
            throw new IllegalArgumentException("O nome deve ter ao menos 3 caracteres.\nDigite novamente.");
        }

        return nome;
        
      }
    
    
     private static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;

            }
        }

        return isEmailIdValid;
    }
            
        //função responsavel por receber o email digitado pelo usuario
        //e chmar a função isValidEmailAddressRegex para verificar o email,
        // guardando seu resultado de retorno na variavel emailAvaliado, e dependedo de seu 
        // resultado sendo true o email será salvo, já sendo false vai se gerar um execption
        // fazendo o programa parar.
    public static String validarEmail(String email) {

        boolean emailAvaliado = isValidEmailAddressRegex(email);

        if (emailAvaliado == false) {
            throw new IllegalArgumentException("Seu email é inválido.\nDigite novamente.");
        } else {
            String emailValido = email;

            return emailValido;

        }
        
    }
    
}
