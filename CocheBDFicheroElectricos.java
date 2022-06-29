package open_bootcamp.Coche_SOL_sesion24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

//TODO Ver el tema de hacer métodos para los 3 tipos de coches

public class CocheBDFicheroElectricos extends CocheBDFichero{
    public String ficheroDatosElectricos = "CochesElectricos.txt";

    @Override
    ArrayList<Coche> obtener() {
        ArrayList<Coche> cochesElectricos = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatosElectricos));

            while (scanner.hasNext()) {
                String cocheActual = scanner.next();
                String[] partes = cocheActual.split(",");

                Coche coche = new CocheElectrico();
                coche.modelo = partes[0];
                coche.marca = partes[1];
                coche.puertas = Integer.parseInt(partes[2]);
                coche.velocidad = Integer.parseInt(partes[3]);
                ((CocheElectrico) coche).tipoBateria = partes[4];

                cochesElectricos.add(coche);
            }

            scanner.close();
        } catch (Exception e) {
                System.out.println("El proceso en ficheroDatosElectricos no pudo concretarse.");
        }

        return cochesElectricos;
    }

    @Override
    Coche buscar(Coche coche) {
        ArrayList<Coche> cochesElectricos = obtener();

        for (Coche cocheActual : cochesElectricos) {
            if (cocheActual.modelo.equalsIgnoreCase(coche.modelo)) {
                return cocheActual;
            }
        }

        return null;
    }

    @Override
    void insertar(Coche coche) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatosElectricos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarCochesElectricosPorComas((CocheElectrico) coche));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println("La inserción no pudo realizarse.");
        }

        incrementarInserciones();
    }

    @Override
    void borrar(Coche coche) {
        ArrayList<Coche> cochesElectricos = obtener();

        for (int i = 0; i < cochesElectricos.size(); i++) {
            if (cochesElectricos.get(i).modelo.equalsIgnoreCase(coche.modelo)) {
                cochesElectricos.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatosElectricos);

            for (Coche cocheActual : cochesElectricos) {
                String cocheComas = separarCochesElectricosPorComas((CocheElectrico) cocheActual);
                printStream.println(cocheComas);
            }

            printStream.close();
        } catch (Exception e) {
            System.out.println("No se pudo imprimir el nuevo fichero.");
        }

        incrementarEliminaciones();
    }

    private String separarCochesElectricosPorComas(CocheElectrico cocheElectrico) {
        return cocheElectrico.modelo + ","
                + cocheElectrico.marca + ","
                + cocheElectrico.puertas + ","
                + cocheElectrico.velocidad + ","
                + cocheElectrico.tipoBateria;
    }
}
