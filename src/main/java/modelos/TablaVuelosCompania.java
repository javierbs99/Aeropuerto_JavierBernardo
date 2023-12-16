/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.sun.java.accessibility.util.SwingEventMonitor;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TablaVuelosCompania extends DefaultTableModel{
    
    public TablaVuelosCompania(){
        addColumn("Código");
        addColumn("Fecha");
        addColumn("H. Salida");
        addColumn("H. Llegada");
        addColumn("N. Plazas ocupadas");
        addColumn("Precio");
    }
    
}
