package entidad;

import java.util.Scanner;

import enumeracion.Colores;
import enumeracion.Consumo;

public final class Lavadora extends Electrodomestico{
    Scanner read = new Scanner(System.in);
// A continuación se debe crear una subclase llamada Lavadora, con el atributo
// carga, además de los atributos heredados.
    private double carga;

// Los constructores que se implementarán serán:
// • Un constructor vacío.
    public Lavadora() {
    }
    
// • Un constructor con la carga y el resto de atributos heredados. Recuerda que
// debes llamar al constructor de la clase padre.
    public Lavadora(double precio, Colores color, Consumo consumo, double peso, double carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

// Los métodos que se implementara serán:
// • Método get y set del atributo carga.
    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    
@Override
    public String toString() {
        return "Lavadora"+super.toString()+"carga=" + carga;
    }

// • Método crearLavadora (): este método llama a crearElectrodomestico() de la
// clase padre, lo utilizamos para llenar los atributos heredados del padre y
// después llenamos el atributo propio de la lavadora.
public Lavadora crearLavadora(){
     // precio, color, consumo energético (letras entre A y F) y peso.
    Electrodomestico nuevo = super.crearElectrodomestico();
    double precio = nuevo.getPrecio();
    Colores color = nuevo.getColor();
    Consumo consumo = nuevo.getConsumo();
    double peso = nuevo.getPeso();
    System.out.println("Ingrese la carga del lavarropas");
    Double carga = read.nextDouble();
    precio = precioFinal(precio, carga, consumo, peso);
    return new Lavadora(precio, color, consumo, peso, carga);
}

// • Método precioFinal(): este método será heredado y se le sumará la siguiente
// funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
// si la carga es menor o igual, no se incrementará el precio. Este método debe
// llamar al método padre y añadir el código necesario. Recuerda que las
// condiciones que hemos visto en la clase Electrodoméstico también deben
// afectar al precio.
public double precioFinal(double precio, double carga, Consumo consumo, double peso){
    precio += super.precioFinal(consumo, peso, precio);
    if(carga>30){
        precio+= 500;
    }
    return precio;
}

}
