package open_bootcamp.Coche_SOL_sesion24;

public class CocheDeCombustible extends Coche{
    String tipoCombustible;

    public CocheDeCombustible(){
        super();
    }

    @Override
    public String toString() {
        return "CocheDeCombustible{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", puertas=" + puertas +
                ", velocidad=" + velocidad +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                '}';
    }
}
