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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javierbs.interfaces.practica1_javierbernardo.entidades.Compania.leerLineas;

/**
 *
 * @author javierbs
 */
public class Vuelo {

    private String codigo;
    private Aeropuerto aOrigen;
    private Aeropuerto aDestino;
    private int nPlazas;
    private java.time.LocalTime hSalida;
    private java.time.LocalTime hLlegada;
    private String diasOpera;

    public Vuelo(String codgo, Aeropuerto aOrigen, Aeropuerto aDestino, int nPlazas, LocalTime hSalida, LocalTime hLlegada, String diasOpera) {
        this.codigo = codgo;
        this.aOrigen = aOrigen;
        this.aDestino = aDestino;
        this.nPlazas = nPlazas;
        this.hSalida = hSalida;
        this.hLlegada = hLlegada;
        this.diasOpera = diasOpera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codgo) {
        this.codigo = codgo;
    }

    public Aeropuerto getAOrigen() {
        return aOrigen;
    }

    public void setAOrigen(Aeropuerto aOrigen) {
        this.aOrigen = aOrigen;
    }

    public Aeropuerto getADestino() {
        return aDestino;
    }

    public void setADestino(Aeropuerto aDestino) {
        this.aDestino = aDestino;
    }

    public int getNPlazas() {
        return nPlazas;
    }

    public void setNPlazas(int nPlazas) {
        this.nPlazas = nPlazas;
    }

    public LocalTime getHSalida() {
        return hSalida;
    }

    public void setHSalida(LocalTime hSalida) {
        this.hSalida = hSalida;
    }

    public LocalTime getHLlegada() {
        return hLlegada;
    }

    public void setHLlegada(LocalTime hLlegada) {
        this.hLlegada = hLlegada;
    }

    public String getDiasOpera() {
        return diasOpera;
    }

    public void setDiasOpera(String diasOpera) {
        this.diasOpera = diasOpera;
    }

    public static ArrayList<Vuelo> leerVuelos() {
        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
        String archivoCSV = "src/main/java/archivos/vuelos.csv";
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
                String codigo = scanner.next();
                String idAOrigen = scanner.next();
                Aeropuerto aOrigen = Aeropuerto.leerPorCodigo(idAOrigen);
                String idADestino = scanner.next();
                Aeropuerto aDestino = Aeropuerto.leerPorCodigo(idADestino);
                int nPlazas = scanner.nextInt();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                String hSalidaSt = scanner.next();
                LocalTime hSalida = LocalTime.parse(hSalidaSt, formato);
                String hLlegadaSt = scanner.next();
                LocalTime hLlegada = LocalTime.parse(hLlegadaSt, formato);
                String diasOpera = scanner.next();
                vuelos.add(new Vuelo(codigo, aOrigen, aDestino, nPlazas, hSalida, hLlegada, diasOpera));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vuelos;
    }

    public void introducirVuelo() {
        String rutaArchivo = "src/main/java/archivos/vuelos.csv";

        try {
            // Crear un FileWriter con la opción de agregar al archivo existente (true)
            FileWriter fileWriter = new FileWriter(rutaArchivo, true);

            // Crear un BufferedWriter y un PrintWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Datos que deseas escribir en el archivo CSV
            // Escribir los datos en el archivo CSV
            printWriter.println(codigo + "," + aOrigen.getCodigo() + "," + aDestino.getCodigo() + "," + nPlazas
                    + "," + hSalida + "," + hLlegada + "," + diasOpera);

            // Cerrar los flujos de escritura
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Datos escritos en el archivo CSV correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validarCodigo(String codigo) {
        String[] codigoArray = codigo.split("");
        if (codigoArray.length < 3) {
            return false;
        }
        String codCompania = "" + codigoArray[0] + codigoArray[1];
        if (!Compania.validarCodCompania(codCompania)) {
            return false;
        }
        String numerosSt = "";
        for (int i = 0; i < codigoArray.length; i++) {
            if (i != 0 && i != 1) {
                numerosSt = numerosSt + codigoArray[i];
            }
        }
        if (!Validacion.esNumero(numerosSt)) {
            System.out.println(numerosSt);
            return false;
        }
        if (!Validacion.compLongitud(numerosSt, 4)) {
            return false;
        }
        if (existeCodigo(codigo)) {
            return false;
        }
        return true;
    }

    public static boolean existeCodigo(String codigo) {
        String archivoCSV = "src/main/java/archivos/vuelos.csv";
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
                if (codigoCSV.equals(codigo)) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> leerLineas() {
        String archivoCSV = "src/main/java/archivos/vuelos.csv";
        List<String> lineas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoCSV));
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            br.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return lineas;
    }

    public void eliminarVuelo() {
        String archivoCSV = "src/main/java/archivos/vuelos.csv";
        List<String> lineas = leerLineas();
        try {
            // Encontrar la línea con el ID deseado y eliminarla
            for (int i = 1; i < lineas.size(); i++) { // Empezar desde 1 para omitir la cabecera
                String[] partes = lineas.get(i).split(",");
                String codigoActual = partes[0].trim();

                if (codigoActual.equals(codigo)) {
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
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void editarVuelo(String codAnterior) {
        String archivoCSV = "src/main/java/archivos/vuelos.csv";
        List<String> lineas = leerLineas();
        String lineaEditada = "";
        try {
            // Encontrar la línea con el ID deseado y eliminarla
            for (int i = 1; i < lineas.size(); i++) { // Empezar desde 1 para omitir la cabecera
                String[] partes = lineas.get(i).split(",");
                String codActual = partes[0].trim();

                if (codActual.equals(codAnterior)) {
                    lineaEditada = codigo + "," + aOrigen.getCodigo() + "," + aDestino.getCodigo() + ","
                            + nPlazas + "," + hSalida + "," + hLlegada
                            + "," + diasOpera;
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
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static Vuelo leerPorCodigo(String codigo) {
        String archivoCSV = "src/main/java/archivos/vuelos.csv";
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
                if (codigoCSV.equals(codigo)) {
                    String idAOrigen = scanner.next();
                    Aeropuerto aOrigen = Aeropuerto.leerPorCodigo(idAOrigen);
                    String idADestino = scanner.next();
                    Aeropuerto aDestino = Aeropuerto.leerPorCodigo(idADestino);
                    int nPlazas = scanner.nextInt();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                    String hSalidaSt = scanner.next();
                    LocalTime hSalida = LocalTime.parse(hSalidaSt, formato);
                    String hLlegadaSt = scanner.next();
                    LocalTime hLlegada = LocalTime.parse(hLlegadaSt, formato);
                    String diasOpera = scanner.next();
                    return new Vuelo(codigo, aOrigen, aDestino, nPlazas, hSalida, hLlegada, diasOpera);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
