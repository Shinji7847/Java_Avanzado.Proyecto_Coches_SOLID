package open_bootcamp.Coche_SOL_sesion24;

import java.util.ArrayList;

public class CocheBDMemoria extends CocheBD{
    ArrayList<Coche> coches = new ArrayList<>();

    @Override
    ArrayList<Coche> obtener() {
        return coches;
    }

    @Override
    Coche buscar(Coche coche) {
        for (Coche cocheActual : obtener()) {
            if (cocheActual.modelo.equalsIgnoreCase(coche.modelo)) {
                return coche;
            }
        }

        return null;
    }

    @Override
    void insertar(Coche coche) {
        for (Coche cocheActual : coches) {
            if (cocheActual.modelo.toLowerCase().equals(coche.modelo.toLowerCase())) {
                return;
            }
        }

        coches.add(coche);
        incrementarInserciones();
    }

    @Override
    void borrar(Coche coche) {
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).modelo.equalsIgnoreCase(coche.modelo)) {
                coches.remove(i);
            }
        }

        incrementarEliminaciones();
    }
}
