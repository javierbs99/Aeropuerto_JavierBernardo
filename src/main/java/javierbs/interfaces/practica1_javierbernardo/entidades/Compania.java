/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javierbs.interfaces.practica1_javierbernardo.entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javierbs
 */
public class Compania {

    private int prefijo;
    private String codigo;
    private String nombre;
    private String direccion;
    private String municipio;
    private String telPasajero;
    private String telAeropuerto;

    public Compania(int prefijo, String codigo, String nombre, String direccion, String municipio,
            String telPasajero, String telAeropuerto) {
        this.prefijo = prefijo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telPasajero = telPasajero;
        this.telAeropuerto = telAeropuerto;
    }

    public int getPrefijo() {
        return this.prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setPrefijo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return this.municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelPasajero() {
        return this.telPasajero;
    }

    public void setTelPasajero(String telPasajero) {
        this.telPasajero = telPasajero;
    }

    public String getTelAeropuerto() {
        return this.telAeropuerto;
    }

    public void setTelAeropuerto(String telAeropuerto) {
        this.telAeropuerto = telAeropuerto;
    }

    public static void validarCodigo(String codigo, String prefijo) {

    }

    public static void introducirCompania(Compania compania) {
        String rutaArchivo = "src/main/java/archivos/companias.csv";

        try {
            // Crear un FileWriter con la opción de agregar al archivo existente (true)
            FileWriter fileWriter = new FileWriter(rutaArchivo, true);

            // Crear un BufferedWriter y un PrintWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Datos que deseas escribir en el archivo CSV
            // Escribir los datos en el archivo CSV
            printWriter.println(compania.getPrefijo() + "," + compania.getCodigo() + "," + compania.getNombre() + "," + compania.getDireccion()
                    + "," + compania.getMunicipio() + "," + compania.getTelPasajero() + "," + compania.getTelAeropuerto());

            // Cerrar los flujos de escritura
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Datos escritos en el archivo CSV correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Compania> leerCompanias() {
        ArrayList<Compania> companias = new ArrayList<Compania>();
        String archivoCSV = "src/main/java/archivos/companias.csv";
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
                int prefijo = scanner.nextInt();
                String codigo = scanner.next();
                String nombre = scanner.next();
                String direccion = scanner.next();
                String municipio = scanner.next();
                String telAeropuerto = scanner.next();
                String telPasajero = scanner.next();
                companias.add(new Compania(prefijo, codigo, nombre, direccion, municipio, telPasajero, telAeropuerto));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return companias;
    }
    
    public static List<String> leerLineas(){
        String archivoCSV = "src/main/java/archivos/companias.csv";
        List<String> lineas = new ArrayList<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            br.close();
        }catch(IOException | NumberFormatException  e){
            e.printStackTrace();
        }
            
        return lineas;
    }
    
    public static void eliminarCompania(Compania compania){
        String archivoCSV = "src/main/java/archivos/companias.csv";
        List<String> lineas = leerLineas();
        String id = compania.getPrefijo()+ compania.getCodigo();
        try{
            // Encontrar la línea con el ID deseado y eliminarla
            for (int i = 1; i < lineas.size(); i++) { // Empezar desde 1 para omitir la cabecera
                String[] partes = lineas.get(i).split(",");
                String idActual = partes[0].trim() + partes[1].trim();

                if (idActual.equals(id)) {
                    lineas.remove(i);
                    break; // Terminar el bucle al encontrar la línea a eliminar
                }
            }

            // Escribir el contenido actualizado de vuelta al archivo CSV
            FileWriter fw = new FileWriter(archivoCSV);

            for (String nuevaLinea : lineas) {
                fw.write(nuevaLinea + "\n");
            }

            fw.close();
        }catch(IOException | NumberFormatException  e){
            e.printStackTrace();
        }
    }
    
    public void editarCompania(String idAnterior){
        String archivoCSV = "src/main/java/archivos/companias.csv";
        List<String> lineas = leerLineas();
        String lineaEditada = "";
        try{
            // Encontrar la línea con el ID deseado y eliminarla
            for (int i = 1; i < lineas.size(); i++) { // Empezar desde 1 para omitir la cabecera
                String[] partes = lineas.get(i).split(",");
                String idActual = partes[0].trim() + partes[1].trim();

                if (idActual.equals(idAnterior)) {
                    lineaEditada = prefijo + "," + codigo + "," + nombre + ","
                            + direccion + "," + municipio + "," + telPasajero
                            + "," + telAeropuerto;
                    lineas.set(i, lineaEditada);
                    break; // Terminar el bucle al encontrar la línea a eliminar
                }
            }

            // Escribir el contenido actualizado de vuelta al archivo CSV
            FileWriter fw = new FileWriter(archivoCSV);

            for (String nuevaLinea : lineas) {
                fw.write(nuevaLinea + "\n");
            }

            fw.close();
        }catch(IOException | NumberFormatException  e){
            e.printStackTrace();
        }
    }
    
    public static boolean validarCodCompania(String codigo){
        String archivoCSV = "src/main/java/archivos/companias.csv";
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
                int prefijoCSV = scanner.nextInt();
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
