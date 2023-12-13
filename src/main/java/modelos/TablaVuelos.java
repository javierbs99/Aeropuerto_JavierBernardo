/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.table.DefaultTableModel;
import javierbs.interfaces.practica1_javierbernardo.entidades.Vuelo;

/**
 *
 * @author Usuario
 */
public class TablaVuelos extends DefaultTableModel{
    
    public TablaVuelos(){
        addColumn("Codigo");
        addColumn("Aer. origen");
        addColumn("Aer. Destino");
        addColumn("N. Plazas");
        addColumn("H. Salida");
        addColumn("H. Llegada");
        addColumn("Días");
        setRowCount(Vuelo.leerVuelos().size());
    }
}
