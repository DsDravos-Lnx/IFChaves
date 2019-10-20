/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 *
 * @author joaqu
 */
public class Data {
    
    
    public static String getData(){
        
        java.util.Date data = new java.util.Date();
        String Novadata;
        Format formatter;
        formatter = new SimpleDateFormat("dd/MM/yyy  HH:mm:ss");
        Novadata = formatter.format(data);
        
        return Novadata;
    }
}
