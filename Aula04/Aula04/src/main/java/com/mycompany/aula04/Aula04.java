/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aula04;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Tiago de Souza Moro Conke
 */
public class Aula04 {

    public static void main(String[] args) {
        Locale loc = Locale.getDefault();
        System.out.println("Olá, Mundo!");
        Date relogio = new Date();
        System.out.println("A hora e data do sistema sao:");
        System.out.println(relogio.toString());
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("Sua tela tem resolução " + d.width + " x " + d.height);
        System.out.println ("O idioma do sistema e: " + loc.getDisplayLanguage());
        
        
    }
}
