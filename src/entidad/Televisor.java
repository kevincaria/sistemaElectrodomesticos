package entidad;

import java.util.Scanner;

import enumeracion.Colores;
import enumeracion.Consumo;

public final class Televisor extends Electrodomestico {
    Scanner read = new Scanner(System.in);
    // Se debe crear también una subclase llamada Televisor con los siguientes
    // atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de
    // los
    // atributos heredados.
    private int pulgadas;
    private boolean sintonizador;

    // Los constructores que se implementarán serán:
    // • Un constructor vacío.
    public Televisor() {
    }

    // • Un constructor con la resolución, sintonizador TDT y el resto de atributos
    // heredados. Recuerda que debes llamar al constructor de la clase padre.
    public Televisor(double precio, Colores color, Consumo consumo, double peso, int pulgadas, boolean sintonizador) {
        super(precio, color, consumo, peso);
        this.pulgadas = pulgadas;
        this.sintonizador = sintonizador;
    }

    // Los métodos que se implementara serán:
    // • Método get y set de los atributos resolución y sintonizador TDT.
    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

    @Override
    public String toString() {
        return "Televisor" + super.toString() + " pulgadas=" + pulgadas + ", sintonizador=" + sintonizador;
    }

    // • Método crearTelevisor(): este método llama a crearElectrodomestico() de la
    // clase padre, lo utilizamos para llenar los atributos heredados del padre y
    // después llenamos los atributos del televisor.
    public Televisor crearTelevisor() {
        Electrodomestico nuevo = super.crearElectrodomestico();
        double precio = nuevo.getPrecio();
        Colores color = nuevo.getColor();
        Consumo consumo = nuevo.getConsumo();
        double peso = nuevo.getPeso();
        System.out.println("Ingrese las pulgadas del televisor: ");
        int pulgadas = read.nextInt();
        System.out.println("Tiene sintonizador? Si/No");
        String opcion = read.next();
        boolean sintonizador = false;
        if (opcion.equalsIgnoreCase("si")) {
            sintonizador = true;
        }
        precio = precioFinal(precio, consumo, peso, pulgadas, sintonizador);
        return new Televisor(precio, color, consumo, peso, pulgadas, sintonizador);
    }

    // • Método precioFinal(): este método será heredado y se le sumará la siguiente
    // funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
    // incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
    // aumentará $500. Recuerda que las condiciones que hemos visto en la clase
    // Electrodomestico también deben afectar al precio.
    private double precioFinal(double precio, Consumo consumo, double peso, int pulgadas, boolean sintonizador) {
        precio += super.precioFinal(consumo, peso, precio);
        if (pulgadas > 40) {
            precio += precio * 0.3;
        }
        if (sintonizador) {
            precio += 500;
        }
        return precio;
    }

}
