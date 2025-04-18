/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apuestas;

/**
 *
 * @author ubuntu
 */
public class Apuestas {
    
    private String nombre;
    private String equipos;
    private double dinero;
    private String fecha;
    private double resultado;

    public Apuestas(String nombre, String equipos, double dinero, String fecha, double resultado) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.dinero = dinero;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipos() {
        return equipos;
    }

    public double getDinero() {
        return dinero;
    }

    public String getFecha() {
        return fecha;
    }
}
