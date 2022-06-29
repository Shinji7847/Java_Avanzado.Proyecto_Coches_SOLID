package open_bootcamp.Coche_SOL_sesion24;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CocheBDFicheroHibridos extends CocheBDFichero{
    public String ficheroDatosHibridos = "CochesHibridos.txt";

    @Override
    ArrayList<Coche> obtener() {
        ArrayList<Coche> cochesHibridos = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatosHibridos));

            while (scanner.hasNext()) {
                String cocheActual = scanner.next();
                String[] partes = cocheActual.split(",");

                Coche coche = new CocheHibrido();
                coche.modelo = partes[0];
                coche.marca = partes[1];
                coche.puertas = Integer.parseInt(partes[2]);
                coche.velocidad = Integer.parseInt(partes[3]);
                ((CocheHibrido) coche).tipoBateria = partes[4];
                ((CocheHibrido) coche).tipoCombustible = partes[5];

                cochesHibridos.add(coche);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("El proceso en ficheroDatosHibridos no pudo concretarse.");
        }

        return cochesHibridos;
    }

    @Override
    Coche buscar(Coche coche) {
        ArrayList<Coche> cochesHibridos = obtener();

        for (Coche cocheActual : cochesHibridos) {
            if (cocheActual.modelo.equalsIgnoreCase(coche.modelo)) {
                return cocheActual;
            }
        }

        return null;
    }

    @Override
    void insertar(Coche coche) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatosHibridos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarCochesHibridosPorComas((CocheHibrido)coche));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println("La inserción no pudo realizarse.");
        }

        incrementarInserciones();
    }

    @Override
    void borrar(Coche coche) {
        ArrayList<Coche> cochesHibridos = obtener();

        for (int i = 0; i < cochesHibridos.size(); i++) {
            if (cochesHibridos.get(i).modelo.equalsIgnoreCase(coche.modelo)) {
                cochesHibridos.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatosHibridos);

            for (Coche cocheActual : cochesHibridos) {
                String cocheComas = separarCochesHibridosPorComas((CocheHibrido) cocheActual);
                printStream.println(cocheComas);
            }

            printStream.close();
        } catch (Exception e) {
            System.out.println("No se pudo imprimir el nuevo fichero.");
        }

        incrementarEliminaciones();
    }

    private String separarCochesHibridosPorComas(CocheHibrido cocheHibrido) {
        return cocheHibrido.modelo + ","
                + cocheHibrido.marca + ","
                + cocheHibrido.puertas + ","
                + cocheHibrido.velocidad + ","
                + cocheHibrido.tipoBateria + ","
                + cocheHibrido.tipoCombustible;
    }
}
