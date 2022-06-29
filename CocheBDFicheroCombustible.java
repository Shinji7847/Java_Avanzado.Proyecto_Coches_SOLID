package open_bootcamp.Coche_SOL_sesion24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CocheBDFicheroCombustible extends CocheBDFichero{
    public String ficheroDatosCombustible = "CochesDeCombustible.txt";

    @Override
    public ArrayList<Coche> obtener() {
        ArrayList<Coche> cochesDeCombustible = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatosCombustible));

            while (scanner.hasNext()) {
                String cocheActual = scanner.next();
                String[] partes = cocheActual.split(",");

                Coche coche = new CocheElectrico();
                coche.modelo = partes[0];
                coche.marca = partes[1];
                coche.puertas = Integer.parseInt(partes[2]);
                coche.velocidad = Integer.parseInt(partes[3]);
                ((CocheDeCombustible) coche).tipoCombustible = partes[4];

                cochesDeCombustible.add(coche);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("El proceso en ficheroDatosCombustible no pudo concretarse.");
        }

        return cochesDeCombustible;
    }

    @Override
    public Coche buscar(Coche coche) {
        ArrayList<Coche> cochesDeCombustible = obtener();

        for (Coche cocheActual : cochesDeCombustible) {
            if (cocheActual.modelo.equalsIgnoreCase(coche.modelo)) {
                return cocheActual;
            }
        }

        return null;
    }

    @Override
    public void insertar(Coche coche) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatosCombustible, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarCochesCombustiblePorComas((CocheDeCombustible) coche));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println("La inserción no pudo realizarse.");
        }

        incrementarInserciones();
    }

    @Override
    public void borrar(Coche coche) {
        ArrayList<Coche> cochesDeCombustible = obtener();

        for (int i = 0; i < cochesDeCombustible.size(); i++) {
            if (cochesDeCombustible.get(i).modelo.equalsIgnoreCase(coche.modelo)) {
                cochesDeCombustible.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatosCombustible);

            for (Coche cocheActual : cochesDeCombustible) {
                String cocheComas = separarCochesCombustiblePorComas((CocheDeCombustible) cocheActual);
                printStream.println(cocheComas);
            }

            printStream.close();
        } catch (Exception e) {
            System.out.println("No se pudo imprimir el nuevo fichero.");
        }

        incrementarEliminaciones();
    }

    private String separarCochesCombustiblePorComas(CocheDeCombustible cocheDeCombustible) {
        return cocheDeCombustible.modelo + ","
                + cocheDeCombustible.marca + ","
                + cocheDeCombustible.puertas + ","
                + cocheDeCombustible.velocidad + ","
                + cocheDeCombustible.tipoCombustible;
    }
}
