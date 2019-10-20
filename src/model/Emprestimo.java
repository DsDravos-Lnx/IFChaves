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
public class Emprestimo {
    
    private int id;
    private int chave_id;
    private int user_id;
    private String data;
    private String hora;
    private String nome_user;
    private String status;
    private String chave_sala;
    private String adm;
    private String data_devolu;
    private String hora_devolu;
    

   
    
    
   
    //private Administrador administrador;

//    public Emprestimo(String data, Chave chave, Usuario usuario) {
//       
//        this.data = data;
//        this.chave_id = chave.getId();
//        this.usuario_id = usuario.getId();
////        this.administrador = administrador;
//    }
    //    public Administrador getAdministrador() {
//        return administrador;
//    }
//
//    public void setAdministrador(Administrador administrador) {
//        this.administrador = administrador;
//    }

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChave_id() {
        return chave_id;
    }

    public void setChave_id(int chave_id) {
        this.chave_id = chave_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChave_sala() {
        return chave_sala;
    }

    public void setChave_sala(String chave_sala) {
        this.chave_sala = chave_sala;
    }

   public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getData_devolu() {
        return data_devolu;
    }

    public void setData_devolu(String data_devolu) {
        this.data_devolu = data_devolu;
    }

    public String getHora_devolu() {
        return hora_devolu;
    }

    public void setHora_devolu(String hora_devolu) {
        this.hora_devolu = hora_devolu;
    }
     
    
}
