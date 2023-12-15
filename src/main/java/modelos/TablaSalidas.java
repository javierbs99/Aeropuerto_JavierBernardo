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
public class TablaSalidas extends DefaultTableModel{
    public TablaSalidas(){
        addColumn("Código");
        addColumn("H. Salida");
        addColumn("N. Plazas ocupadas");
        addColumn("Precio");
    }
    
}
