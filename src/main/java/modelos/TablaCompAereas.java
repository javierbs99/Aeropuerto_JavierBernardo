/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.swing.table.DefaultTableModel;
import javierbs.interfaces.practica1_javierbernardo.entidades.Compania;

/**
 *
 * @author Usuario
 */
public class TablaCompAereas extends DefaultTableModel{
    
    public TablaCompAereas(){
        addColumn("Prefijo");
        addColumn("Código");
        addColumn("Nombre");
        addColumn("Dirección");
        addColumn("Municipio");
        addColumn("Info. Tel Pasajero");
        addColumn("Info. Tel Aeropuerto");
        int numFilas = Compania.leerCompanias().size();
        setRowCount(numFilas);
    }
    
}
