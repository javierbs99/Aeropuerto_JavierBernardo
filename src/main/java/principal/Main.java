/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import formularios.FrmPrincipal;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author javierbs
 */
public class Main {

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);              
            }
        });
    }
    
}
