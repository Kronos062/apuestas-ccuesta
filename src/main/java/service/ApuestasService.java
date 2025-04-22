package service;

import Apuestas.Apuestas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ubuntu
 */
public class ApuestasService {

    private List<Apuestas> apuestas = new ArrayList<>();

    // Obtener todas las apuestas
    public List<Apuestas> getAllApuestas() {
        return apuestas;
    }

    // Añadir nueva apuesta
    public void addApuesta(Apuestas apuesta) {
        apuestas.add(apuesta);
    }

    // Eliminar apuesta por índice
    public void deleteApuesta(int index) {
        if(index >= 0 && index < apuestas.size()) {
            apuestas.remove(index);
        }
    }

    // Modificar apuesta existente
    public void modifyApuesta(int index, Apuestas apuesta) {
        if(index >= 0 && index < apuestas.size()) {
            Apuestas existente = apuestas.get(index);
            existente.setNombre(apuesta.getNombre());
            existente.setEquipos(apuesta.getEquipos());
            existente.setDinero(apuesta.getDinero());
            existente.setFecha(apuesta.getFecha());
            existente.setResultado(apuesta.getResultado());
        }
    }

    // Obtener apuesta específica
    public Apuestas getApuesta(int index) {
        if(index >= 0 && index < apuestas.size()) {
            return apuestas.get(index);
        }
        return null;
    }

    // Filtrar apuestas por nombre (con for e if)
        public List<Apuestas> filtrarApuestas(String nombre) {
        List<Apuestas> resultado = new ArrayList<>();
        if (nombre == null || nombre.trim().isEmpty()) {
            resultado.addAll(apuestas);
        } else {
            String filtro = nombre.toLowerCase();
            for (Apuestas a : apuestas) {
                if (a.getNombre().toLowerCase().contains(filtro)) {
                    resultado.add(a);
                }
            }
        }
        return resultado;
    }
}
