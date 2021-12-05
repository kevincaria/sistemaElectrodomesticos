package entidad;

import java.util.Scanner;

import enumeracion.Colores;
import enumeracion.Consumo;

public class Electrodomestico {
    Scanner read = new Scanner(System.in);
    // Crear una superclase llamada Electrodoméstico con los siguientes atributos:
    // precio, color, consumo energético (letras entre A y F) y peso.
    protected double precio;
    protected Colores color;
    protected Consumo consumo;
    protected double peso;

    // Los constructores que se deben implementar son los siguientes:
    // • Un constructor vacío.
    public Electrodomestico() {
    }

    // • Un constructor con todos los atributos pasados por parámetro.
    public Electrodomestico(double precio, Colores color, Consumo consumo, double peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    // Los métodos a implementar son:
    // • Métodos getters y setters de todos los atributos.
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "color=" + color + ", consumo=" + consumo + ", peso=" + peso + ", precio=" + precio;
    }

    // • Método comprobarConsumoEnergetico(char letra): comprueba que la letra
    // es correcta, sino es correcta usara la letra F por defecto. Este método se
    // debe invocar al crear el objeto y no será visible.

    private Consumo comprobarConsumoEnergetico(String letra) {
        Consumo comprobado = Consumo.F;
        for (Consumo auxiliar : Consumo.values()) {
            if (auxiliar.toString().equalsIgnoreCase(letra)) {
                comprobado = auxiliar;
            }
        }
        // if(letra.equals(Consumo.A.name())) {
        // comprobado = Consumo.A;
        // } else if(letra.equals(Consumo.B.name())) {
        // comprobado = Consumo.B;
        // } else if(letra.equals(Consumo.C.name())) {
        // comprobado = Consumo.C;
        // } else if(letra.equals(Consumo.D.name())) {
        // comprobado = Consumo.D;
        // } else if(letra.equals(Consumo.E.name())) {
        // comprobado = Consumo.E;
        // } else{
        // comprobado = Consumo.F;
        // }
        return comprobado;
    }

    // • Método comprobarColor(String color): comprueba que el color es correcto, y
    // si no lo es, usa el color blanco por defecto. Los colores disponibles para
    // los
    // electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el
    // nombre
    // está en mayúsculas o en minúsculas. Este método se invocará al crear el
    // objeto y no será visible.
    private Colores comprobarColor(String palabra) {
        Colores comprobado = Colores.BLANCO;

        for (Colores auxiliar : Colores.values()) {
            if (auxiliar.toString().equalsIgnoreCase(palabra)) {
                comprobado = auxiliar;
            }
        }

        return comprobado;
    }

    // • Método precioFinal(): según el consumo energético y su tamaño, aumentará
    // el valor del precio. Esta es la lista de precios:
    // LETRA PRECIO
    // A $1000
    // B $800
    // C $600
    // D $500
    // E $300
    // F $100

    public double precioFinal(Consumo consumo, double peso, double precio) {
        switch (consumo.toString()) {
            case "A":
                precio += 1000;
                break;
            case "B":
                precio += 800;
                break;
            case "C":
                precio += 600;
                break;
            case "D":
                precio += 500;
                break;
            case "E":
                precio += 300;
                break;
            case "F":
                precio += 100;
                break;
        }
        // PESO PRECIO
        // Entre 1 y 19 kg $100
        // Entre 20 y 49 kg $500
        // Entre 50 y 79 kg $800
        // Mayor que 80 kg $1000
        if (peso >= 1 && peso <= 19) {
            precio += 100;
        } else if (peso >= 20 && peso <= 49) {
            precio += 500;
        } else if (peso >= 50 && peso <= 79) {
            precio += 800;
        } else if (peso >= 80) {
            precio += 1000;
        }
        return precio;
    }

    // • Metodo crearElectrodomestico(): le pide la información al usuario y llena
    // el electrodoméstico, también llama los métodos para comprobar el color y el
    // consumo. Al precio se le da un valor base de $1000.
    // Crear una superclase llamada Electrodoméstico con los siguientes atributos:
    // precio, color, consumo energético (letras entre A y F) y peso.
    public Electrodomestico crearElectrodomestico() {
        double precio = 1000;
        System.out.println("Ingrese el precio del Electrodomestico");
        precio += read.nextDouble();
        System.out.println("Ingrese el color");
        String nuevo = read.next();
        Colores color = comprobarColor(nuevo);
        System.out.println("Ingrese el consumo energético");
        String energetico = read.next();
        Consumo consumo = comprobarConsumoEnergetico(energetico);
        System.out.println("Ingrese el peso");
        Double peso = read.nextDouble();
        return new Electrodomestico(precio, color, consumo, peso);
    }

}
