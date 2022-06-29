package open_bootcamp.Coche_SOL_sesion24;

abstract public class Coche {
    String modelo;
    String marca;
    int puertas;
    int velocidad = 0;

    public void Encender(){
        System.out.println("El coche eléctrico está encendido.");
    }
    public void acelerar(){
        velocidad++;
    }
    public void frenar(){
        if(velocidad > 0){
            velocidad--;
        } else{
            System.out.println("El coche no está en movimiento.");
        }
    }
    public void Apagar(){
        System.out.println("El coche eléctrico está apagado.");
    }
}
