import java.util.ArrayList;
import java.util.Scanner;
import entidad.Electrodomestico;
import entidad.Lavadora;
import entidad.Televisor;

// Finalmente, en el main debemos realizar lo siguiente:
// Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios
// para mostrar el precio final de los dos electrodomésticos.
//  en el main vamos a crear un ArrayList de
// Electrodomésticos para guardar 4 electrodomésticos, ya sean lavadoras o
// televisores, con valores ya asignados.
// Luego, recorrer este array y ejecutar el método precioFinal() en cada
// electrodoméstico. Se deberá también mostrar el precio de cada tipo de objeto,
// es decir, el precio de todos los televisores y el de las lavadoras. Una vez hecho
// eso, también deberemos mostrar, la suma del precio de todos los
// Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 2000
// y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
// electrodomésticos, 2000 para lavadora y 5000 para televisor.

public class App {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
        int op;
        int op2 = 0;
        double precioFinal = 0;
        do {
            System.out.println("Ingreso de electrodomésticos");
            System.out.println("MENU");
            System.out.println("1.Cargar Electrodomésticos");
            System.out.println("2.Mostrar  lista de Electrodomésticos");
            System.out.println("3.Mostrar precio final");
            System.out.println("4.Salir");
            System.out.println("Ingrese una opcion: ");

            op = read.nextInt();
            while (op < 0 || op > 4) {
                System.out.println("Opcion incorrecta, elija la opcion 1 y 4");
                op = read.nextInt();
            }

            switch (op) {
                case 1:
                    cargarElectrodomesticos(electrodomesticos);
                    break;
                case 2:
                    for (Electrodomestico electrodomestico : electrodomesticos) {
                         System.out.println(electrodomestico.toString());
                    }
                    break;
                case 3:
                    for (Electrodomestico electrodomestico : electrodomesticos) {
                        precioFinal+=electrodomestico.getPrecio();
                    }
                    System.out.println("El precio total de todos los electrodomesticos es "+precioFinal);
                    break;
                case 4:
                    System.out.println("Esta seguro que desea salir?");
                    System.out.println("1.Si");
                    System.out.println("2.No");
                    op2 = read.nextInt();
                    while (op2 != 1 && op2 != 2) {
                        System.out.println("Ingrese una opcion correcta");
                        op2 = read.nextInt();
                    }
            }
        } while (op2 != 1);
    }

    public static void cargarElectrodomesticos(ArrayList<Electrodomestico>electrodomesticos){
        Televisor nuevo = new Televisor();
        Lavadora nueva = new Lavadora();
        Scanner read = new Scanner(System.in);
        int op3 = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Que producto desea ingresar?");
            System.out.println("1. Lavadora");
            System.out.println("2. Televisor");
            op3 = read.nextInt();
            while (op3 < 0 || op3 > 2) {
                System.out.println("Opcion incorrecta, elija la opcion 1 o 2");
                op3 = read.nextInt();
            }
            if (op3==1){
                nueva = nueva.crearLavadora();
                electrodomesticos.add(nueva);
            }else{
                nuevo = nuevo.crearTelevisor();
                electrodomesticos.add(nuevo);
            }
        }
    }
}
