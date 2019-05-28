package aplicacion;

/*
 Class Utilidades
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*import java.util.logging.Level;
import java.util.logging.Logger;*/
/**
 *
 * @author Jaime M. Botonero Morillo
 */
public class Utilidades {

    public static double leerDoble(String cadena) {

        BufferedReader Entrada = new BufferedReader(new InputStreamReader(System.in));

        double Numero = 0;
        boolean continuar = false;
        do {
            System.out.print(cadena);
            try {
                Numero = Double.parseDouble(Entrada.readLine());
            } catch (NumberFormatException ex) {
                System.out.println("No has introducido un n√∫mero double correcto.");
                continuar = true;
            } catch (IOException ex) {
                System.out.println("Se ha producido un error de entrada/salida gen√©rico.");
                continuar = true;
            }
        } while (continuar);
        return Numero;
    }

    public static int leerEntero(String cadena) {

        Scanner teclado = new Scanner(System.in);

        int numero = 0;
        boolean continuar;

        do {
            continuar = false;
            System.out.print(cadena);

            try {

                numero = teclado.nextInt();

            } catch (Exception e) {
                continuar = true;
                System.out.println("Ha introducido un valor erroneo.");
                teclado.nextLine();
            }

        } while (continuar);
        return numero;
    }

    public static String leerDatos(String cadena) {
        Scanner teclado = new Scanner(System.in);

        String pedirDato = "";
        boolean continuar = false;
        do {
            System.out.print(cadena);

            continuar = true;
            pedirDato = teclado.nextLine();

            if (!pedirDato.matches("([A-Za-z¡…Õ”⁄·ÈÌÛ˙0-9∫ /' '/]){0,20}")) {
                System.out.println("ERROR, NOMBRE INTRODUCIDO NO VALIDO");

                continuar = false;

            }

        } while (!continuar);

        return pedirDato;

    }

    public static String leerCadena(String cadena) {

        Scanner teclado = new Scanner(System.in);

        String pedirDato = "";
        boolean continuar;
        do {
            continuar = false;
            System.out.print(cadena);

            pedirDato = teclado.nextLine();

            if (!pedirDato.matches("([A-Za-z¡…Õ”⁄·ÈÌÛ˙Ò—/' '/]){0,50}")) {
                System.out.println("ERROR, NOMBRE INTRODUCIDO NO VALIDO");

                continuar = true;

            }

        } while (continuar);

        return pedirDato;
    }

    public static void borrarPantalla() {
        for (int i = 0; i < 29; i++) {
            System.out.println();
        }
    }

    public static String formatoColumna(String texto, int largo) {
        int restaLargo = largo - texto.length();
        for (int indice = 0; indice < restaLargo; indice++) {
            texto = texto + " ";
        }
        return texto;
    }
    
    public static String validarDni(String dni) {

        dni = dni.toUpperCase();
        String dniCorrecto = "";
        if (dni.length() < 9) {

            System.out.println("El dni esta mal introducido");

        } else {

            String a[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

            if (dni.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")) {
                int restoDni;
                restoDni = Integer.parseInt(dni.substring(0, 8)) % 23;

                if (a[restoDni].equalsIgnoreCase(dni.substring(8))) {

                    dniCorrecto = dni;

                } else {

                    dniCorrecto = dni.substring(0, 8) + a[restoDni];

                }

            }

        }
        return dniCorrecto;
    }

}
