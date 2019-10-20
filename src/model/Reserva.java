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
public class Reserva { 
    
    private int    id;
    private String dia_inicio;
    private String hora_inicio;
    private String chave_sala;
    private String nome_user;
    private String nome_admin;
    private String dia_encerra;
    private String hora_encerra;
    private int    chave_id;
    private int    user_id;
    private int    admin_id;

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia_inicio() {
        return dia_inicio;
    }

    public void setDia_inicio(String dia_inicio) {
        this.dia_inicio = dia_inicio;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getChave_sala() {
        return chave_sala;
    }

    public void setChave_sala(String chave_sala) {
        this.chave_sala = chave_sala;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getNome_admin() {
        return nome_admin;
    }

    public void setNome_admin(String nome_admin) {
        this.nome_admin = nome_admin;
    }

    public String getDia_encerra() {
        return dia_encerra;
    }

    public void setDia_encerra(String dia_encerra) {
        this.dia_encerra = dia_encerra;
    }

    public String getHora_encerra() {
        return hora_encerra;
    }

    public void setHora_encerra(String hora_encerra) {
        this.hora_encerra = hora_encerra;
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

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", dia_inicio=" + dia_inicio + ", hora_inicio=" + hora_inicio + ", chave_sala=" + chave_sala + ", nome_user=" + nome_user + ", nome_admin=" + nome_admin + ", dia_encerra=" + dia_encerra + ", hora_encerra=" + hora_encerra + ", chave_id=" + chave_id + ", user_id=" + user_id + ", admin_id=" + admin_id + '}';
    }
    
    
    
    
    
    
}
