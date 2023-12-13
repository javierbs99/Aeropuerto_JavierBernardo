/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.table.DefaultTableModel;
import javierbs.interfaces.practica1_javierbernardo.entidades.VueloDiario;

/**
 *
 * @author Usuario
 */
public class TablaVuelosDiarios extends DefaultTableModel{
    
    public TablaVuelosDiarios(){
        addColumn("Código de vuelo");
        addColumn("Fecha");
        addColumn("H. Salida");
        addColumn("H. Llegada");
        addColumn("N. plazas ocupadas");
        addColumn("Precio");
        setRowCount(VueloDiario.leerVuelosDiarios().size());
    }
    
}
