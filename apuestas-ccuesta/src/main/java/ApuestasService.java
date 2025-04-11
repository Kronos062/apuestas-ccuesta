
import Apuestas.Apuestas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ubuntu
 */
public class ApuestasService {

    private List<Apuestas> apuestas;

    public ApuestasService() {
        this.apuestas = new ArrayList<>();
    }

    // metodo para obtener todas las apuestas
    public List<Apuestas> getAllApuestas() {
        return apuestas;
    }

    // metodo para añadir una apuesta
    public void addApuesta(Apuestas apuesta) {
        apuestas.add(apuesta);
    }

    // metodo para eliminar una apuesta
    public void deleteApuesta(int index) {
        if (index >= 0 && index < apuestas.size()) {
            apuestas.remove(index);
        }
    }

    // metodo para modificar una apuesta existente
    public void modifyApuesta(int index, Apuestas apuesta) {
        if (index >= 0 && index < apuestas.size()) {
            Apuestas existingApuesta = apuestas.get(index);
            existingApuesta.setNombre(apuesta.getNombre());
            existingApuesta.setEquipos(apuesta.getEquipos());
            existingApuesta.setDinero(apuesta.getDinero());
            existingApuesta.setFecha(apuesta.getFecha());
            existingApuesta.setResultado(apuesta.getResultado());
        }
    }

    //metodo para obtener una apuesta específica por su índice
    public Apuestas getApuesta(int index) {
        if (index >= 0 && index < apuestas.size()) {
            return apuestas.get(index);
        }
        return null;
    }

    //obtener el número total de apuestas
    public int getApuestasCount() {
        return apuestas.size();
    }

    //metodo para filtrar apuestas por nombre
    public List<Apuestas> filtrarApuestas(String filtro) {
        List<Apuestas> filtradas = new ArrayList<>();
        
        if(filtro == null || filtro.isEmpty()) {
            return new ArrayList<>(apuestas);
        }
        
        String filtroLower = filtro.toLowerCase();
        for(Apuestas a : apuestas) {
            if(a.getNombre().toLowerCase().contains(filtroLower)) {
                filtradas.add(a);
            }
        }
        return filtradas;
    }
}
