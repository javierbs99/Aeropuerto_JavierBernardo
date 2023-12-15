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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javierbs.interfaces.practica1_javierbernardo.entidades.Vuelo.leerLineas;

/**
 *
 * @author javierbs
 */
public class VueloDiario {

    private String vuelo;
    private java.time.LocalDate fecha;
    private java.time.LocalTime hSalida;
    private java.time.LocalTime hLlegada;
    private int nPlazasOcupadas;
    private double precioVuelo;

    public VueloDiario(String vuelo, LocalDate fecha, LocalTime hSalida, LocalTime hLlegada, int nPlazasOcupadas, double precioVuelo) {
        this.vuelo = vuelo;
        this.fecha = fecha;
        this.hSalida = hSalida;
        this.hLlegada = hLlegada;
        this.nPlazasOcupadas = nPlazasOcupadas;
        this.precioVuelo = precioVuelo;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime gethSalida() {
        return hSalida;
    }

    public void sethSalida(LocalTime hSalida) {
        this.hSalida = hSalida;
    }

    public LocalTime gethLlegada() {
        return hLlegada;
    }

    public void sethLlegada(LocalTime hLlegada) {
        this.hLlegada = hLlegada;
    }

    public int getnPlazasOcupadas() {
        return nPlazasOcupadas;
    }

    public void setnPlazasOcupadas(int nPlazasOcupadas) {
        this.nPlazasOcupadas = nPlazasOcupadas;
    }

    public double getPrecioVuelo() {
        return precioVuelo;
    }

    public void setPrecioVuelo(double precioVuelo) {
        this.precioVuelo = precioVuelo;
    }

    public static boolean validarNPlazasOcupadas(int nPlazasOcupadas, String codigo) {
        Vuelo vuelo = Vuelo.leerPorCodigo(codigo);
        if (nPlazasOcupadas > vuelo.getNPlazas() || nPlazasOcupadas < 0) {
            return false;
        } else {
            return true;
        }
    }

    public static ArrayList<VueloDiario> leerVuelosDiarios() {
        ArrayList<VueloDiario> vuelosDiarios = new ArrayList<VueloDiario>();
        String archivoCSV = "src/main/java/archivos/vuelosDiarios.csv";
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
                String fechaSt = scanner.next();
                LocalDate fecha = Validacion.parsearFecha(fechaSt);
                String hSalidaSt = scanner.next();
                LocalTime hSalida = Validacion.parsearHora(hSalidaSt);
                String hLlegadaSt = scanner.next();
                LocalTime hLlegada = Validacion.parsearHora(hLlegadaSt);
                int nPlazasOcupadas = scanner.nextInt();
                String precioSt = scanner.next();
                double precio = Double.parseDouble(precioSt);
                vuelosDiarios.add(new VueloDiario(codigo, fecha, hSalida, hLlegada, nPlazasOcupadas, precio));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vuelosDiarios;
    }

    public void introducirVueloDiario() {
        String rutaArchivo = "src/main/java/archivos/vuelosDiarios.csv";

        try {
            // Crear un FileWriter con la opción de agregar al archivo existente (true)
            FileWriter fileWriter = new FileWriter(rutaArchivo, true);

            // Crear un BufferedWriter y un PrintWriter para escribir en el archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            String mes = Validacion.parsearMes(fecha.getMonthValue());
            String fechaSt = fecha.getDayOfMonth() + "/" + mes + "/" + fecha.getYear();

            // Datos que deseas escribir en el archivo CSV
            // Escribir los datos en el archivo CSV
            printWriter.println(vuelo + "," + fechaSt + "," + hSalida + "," + hLlegada
                    + "," + nPlazasOcupadas + "," + precioVuelo);

            // Cerrar los flujos de escritura
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Datos escritos en el archivo CSV correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> leerLineas() {
        String archivoCSV = "src/main/java/archivos/vuelosDiarios.csv";
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

    public void eliminarVueloDiario() {
        String archivoCSV = "src/main/java/archivos/vuelosDiarios.csv";
        List<String> lineas = leerLineas();
        try {
            // Encontrar la línea con el ID deseado y eliminarla
            for (int i = 1; i < lineas.size(); i++) { // Empezar desde 1 para omitir la cabecera
                String[] partes = lineas.get(i).split(",");
                String codigoActual = partes[0].trim();
                String fechaActualSt = partes[1].trim();
                LocalDate fechaActual = Validacion.parsearFecha(fechaActualSt);

                if (codigoActual.equals(vuelo) && fecha.equals(fechaActual)) {
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

    public void editarVueloDiario(String codAnterior, String fechaSt) {
        String archivoCSV = "src/main/java/archivos/vuelosDiarios.csv";
        List<String> lineas = leerLineas();
        String lineaEditada = "";
        try {
            // Encontrar la línea con el ID deseado y eliminarla
            for (int i = 1; i < lineas.size(); i++) { // Empezar desde 1 para omitir la cabecera
                String[] partes = lineas.get(i).split(",");
                String codActual = partes[0].trim();
                String fechaActual = partes[1].trim();

                if (codActual.equals(codAnterior) && fechaActual.equals(fechaSt)) {
                    String fechaParseada = Validacion.parsearFechaAString(fecha);
                    lineaEditada = vuelo + "," + fechaParseada + "," + hSalida + ","
                            + hLlegada + "," + nPlazasOcupadas + "," + precioVuelo;
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

    public static boolean existeVueloDiarioId(String codigo, String fecha, String codigoEditar, String fechaEditar) {
        String archivoCSV = "src/main/java/archivos/vuelosDiarios.csv";
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
                String codigoCsv = scanner.next();
                String fechaCsv = scanner.next();
                if (codigoEditar != null && fechaEditar != null) {
                    if (codigo.equals(codigoEditar) && fecha.equals(fechaEditar)) {
                        return false;
                    } else {
                        if (codigoCsv.equals(codigo) && fechaCsv.equals(fecha)) {
                            return true;
                        }
                    }
                } else {
                    if (codigoCsv.equals(codigo) && fechaCsv.equals(fecha)) {
                        return true;
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<VueloDiario> leerVueloDiarioPorFecha(String fecha) {
        ArrayList<VueloDiario> vuelosDiarios = new ArrayList<VueloDiario>();
        String archivoCSV = "src/main/java/archivos/vuelosDiarios.csv";
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
                String fechaSt = scanner.next();
                if (fechaSt.equals(fecha)) {
                    LocalDate fechaCsv = Validacion.parsearFecha(fechaSt);
                    String hSalidaSt = scanner.next();
                    LocalTime hSalida = Validacion.parsearHora(hSalidaSt);
                    String hLlegadaSt = scanner.next();
                    LocalTime hLlegada = Validacion.parsearHora(hLlegadaSt);
                    int nPlazasOcupadas = scanner.nextInt();
                    String precioSt = scanner.next();
                    double precio = Double.parseDouble(precioSt);
                    vuelosDiarios.add(new VueloDiario(codigo, fechaCsv, hSalida, hLlegada, nPlazasOcupadas, precio));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return vuelosDiarios;
    }

}
