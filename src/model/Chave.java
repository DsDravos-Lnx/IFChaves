/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joaqu
 */
public class Chave {
    
    private int id;
    private String sala;
     private String bloco;
    private String status;
   // private int numero;

    public Chave(String sala, String bloco, String status) {
        this.id = id;
        this.sala = validarSala(sala);
         this.bloco = validarBloco(bloco);
        this.status = status;
    }

    public Chave() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public int getNumero() {
//        return numero;
//    }
//
//    public void setNumero(int numero) {
//        this.numero = numero;
//    }
    
   
     private static String validarSala(String nome) {

        if (nome.isEmpty() || nome.length() < 3) {
            throw new IllegalArgumentException("O nome da sala deve ter ao menos 3 caracteres.\nDigite novamente.");
        }

        return nome;
        
      }
     
     
      private static String validarBloco(String nome) {

        if (nome.isEmpty() || nome.length() < 3) {
            throw new IllegalArgumentException("O nome do bloco deve ter ao menos 3 caracteres.\nDigite novamente.");
        }

        return nome;
        
      }
    
    
    
}
