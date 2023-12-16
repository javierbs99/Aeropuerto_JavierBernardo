/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TablaLlegadas extends DefaultTableModel{
    
    public TablaLlegadas(){
        addColumn("Código");
        addColumn("H. Llegada");
        addColumn("N. Plazas ocupadas");
        addColumn("Precio");
    }
    
}
