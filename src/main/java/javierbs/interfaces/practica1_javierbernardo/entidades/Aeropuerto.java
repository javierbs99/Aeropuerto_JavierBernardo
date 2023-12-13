/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javierbs.interfaces.practica1_javierbernardo.entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author javierbs
 */
public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String codMunicipio;

    public Aeropuerto(String codigo, String nombre, String codMunicipio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codMunicipio = codMunicipio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }
    
    public static Aeropuerto leerPorCodigo(String codigo){
        Aeropuerto aeropuerto = null;
        String archivoCSV = "src/main/java/archivos/aeropuertos.csv";
        boolean primeraLinea = true;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;


            while ((linea = br.readLine()) != null) {

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                Scanner scanner = new Scanner(linea);
                scanner.useDelimiter(",");    
                String codigoCSV = scanner.next();
                if(codigoCSV.equals(codigo)){
                    String nombre = scanner.next();
                    String codMunicipio = scanner.next();
                    return new Aeropuerto(codigo, nombre, codMunicipio);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return aeropuerto;
    }
    
    public static Aeropuerto leerPorNombre(String nombre){
        Aeropuerto aeropuerto = null;
        String archivoCSV = "src/main/java/archivos/aeropuertos.csv";
        boolean primeraLinea = true;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;


            while ((linea = br.readLine()) != null) {

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                Scanner scanner = new Scanner(linea);
                scanner.useDelimiter(",");    
                String codigoCSV = scanner.next();
                String nombreCSV = scanner.next();
                if(nombreCSV.equals(nombre)){
                    String codMunicipio = scanner.next();
                    return new Aeropuerto(codigoCSV, nombre, codMunicipio);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return aeropuerto;
    }
    
    public static boolean validarCodigo(String codigo){
        String archivoCSV = "src/main/java/archivos/aeropuertos.csv";
        boolean primeraLinea = true;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;


            while ((linea = br.readLine()) != null) {

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                Scanner scanner = new Scanner(linea);
                scanner.useDelimiter(",");    
                String codigoCSV = scanner.next();
                if(codigoCSV.equals(codigo)){
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
