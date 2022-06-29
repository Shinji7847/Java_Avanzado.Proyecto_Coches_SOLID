package open_bootcamp.Coche_SOL_sesion24;

public class CocheHibrido extends Coche{
    String tipoCombustible;
    String tipoBateria;

    public CocheHibrido(){
        super();
    }

    @Override
    public String toString() {
        return "CocheHibrido{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", puertas=" + puertas +
                ", velocidad=" + velocidad +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", tipoBateria='" + tipoBateria + '\'' +
                '}';
    }
}
