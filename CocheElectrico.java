package open_bootcamp.Coche_SOL_sesion24;

public class CocheElectrico extends Coche {
    String tipoBateria;

    public CocheElectrico() {
        super();
    }

    @Override
    public String toString() {
        return "CocheElectrico{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", puertas=" + puertas +
                ", velocidad=" + velocidad +
                ", tipoBateria='" + tipoBateria + '\'' +
                '}';
    }
}
