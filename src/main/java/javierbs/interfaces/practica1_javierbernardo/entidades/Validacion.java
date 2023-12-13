/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javierbs.interfaces.practica1_javierbernardo.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author javierbs
 */
public class Validacion {
    public static boolean esNumero(String numero){
        try {
            // Intenta convertir el String a un número entero
            int numeroEntero = Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean sonDiasOperables(String dias){
        Pattern patron = Pattern.compile("^L?M?X?J?V?S?D?$");
        Matcher matcher = patron.matcher(dias);
        return matcher.matches();
    }
    
    public static boolean validarHora(String hora){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            // Intenta parsear el String a LocalTime usando el formatter
            LocalTime localTime = LocalTime.parse(hora, formatter);
            return true;
        } catch (DateTimeParseException e) {
            // La excepción indica que el String no pudo ser parseado a LocalTime
            return false;
        }
    }
    
    public static boolean validarFecha(String fecha){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Intenta parsear el String a LocalTime usando el formatter
            LocalDate localDate = LocalDate.parse(fecha, formatter);
            return true;
        } catch (DateTimeParseException e) {
            // La excepción indica que el String no pudo ser parseado a LocalTime
            return false;
        }
    }
    
    public static boolean compLongitud(String s, int longitud){
        String[] stringArray = s.split("");
        return stringArray.length <= longitud;
    }
    
    public static LocalTime parsearHora(String hora){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaLocalTime = LocalTime.parse(hora, formato);
        return horaLocalTime;
    }
    
    public static LocalDate parsearFecha(String fecha){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Parsea la cadena a LocalDate
            LocalDate fechaParseada = LocalDate.parse(fecha, formatoFecha);
            return fechaParseada;

        } catch (Exception e) {
            // Manejo de la excepción en caso de que la cadena no sea válida para el formato especificado
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return null;
        }
    }
    
    public static String parsearFechaAString(LocalDate fechaLD){
        String fecha = "";
        String mes = parsearMes(fechaLD.getMonthValue());
        fecha = fechaLD.getDayOfMonth() + "/" + mes + "/" + fechaLD.getYear();
        return fecha;
    }
    
    public static boolean esDouble(String n){
        try {
            // Intenta convertir la cadena a un número double
            double numero = Double.parseDouble(n);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static String parsearMes(int mes){
        String mesSt;
        if(mes < 10){
            mesSt = "0" + mes;
        }else{
            mesSt = "" + mes;
        }
        return mesSt;
    }
}
