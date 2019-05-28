
import java.util.Scanner;

public class Agenda {

    private static ConectorBD bD;

    public static void main(String[] args) {

        bD = new ConectorBD();
        int opcion = -1;
        do {
            mostrarMenu();

            opcion = Utilidades.leerEntero("Introduzca la opción deseada: ");
            tratarOpcionMenu(opcion);

        } while (opcion != 0);

    }

    public static void mostrarMenu() {

        System.out.println("1.- Buscar Datos de una persona, por su dni: ");
        System.out.println("2.- Dar de alta una persona en la agenda: ");
        System.out.println("3.- Borrar los datos de una persona por su dni: ");
        System.out.println("4.- Listar las personas de la agenda correctamente tabuladas");

    }

    public static void tratarOpcionMenu(int opcion) {

        switch (opcion) {

            case 1:
                buscarDatosDni();
                break;
            case 2:
                altaPersona();
                break;
            case 3:
                borrarPersona();
                break;
            case 4:
                listarPersonas();
                break;

        }

    }

    private static void listarPersonas() {

        if (!bD.mostrarDatos().equalsIgnoreCase("")) {
            System.out.println("");
            System.out.println(bD.mostrarDatos());

        } else {

            System.out.println("No se ha podido mostrar datos.");

        }

    }

    private static void borrarPersona() {

        String dni = "";

        dni = Utilidades.leerCadena("Introduce el dni que desea borrar: ");

        if (bD.borrarPersona(dni)) {

            System.out.println("Se ha borrado la persona.");

        } else {

            System.out.println("No se ha podido borrar.");
        }

    }

    private static void altaPersona() {

        Scanner teclado = new Scanner(System.in);

        Persona p = new Persona();

        p.setNombre(Utilidades.leerCadena("Introduce el nombre de la persona: "));

        p.setApellidos(Utilidades.leerCadena("Introduce el apellido de la persona: "));

        p.setTelefono(Utilidades.leerEntero("Introduce el telegono de la persona: "));

        p.setEdad(Utilidades.leerEntero("Introduce la edad de la persona: "));

        System.out.print("Introduce el peso de la persona: ");
        double peso = teclado.nextDouble();

        p.setPeso(peso);

        String dni = Utilidades.leerCadena("Introduce el dni de la persona: ");

        dni = Utilidades.validarDni(dni);

        p.setDni(dni);

        if (bD.altaPersona(p)) {

            System.out.println("Persona dada de alta correctamente.");

        } else {

            System.out.println("No se pudo dar de alta la persona.");

        }

    }

    private static void buscarDatosDni() {

        String dni = "";

        dni = Utilidades.leerCadena("Introduce el dni a buscar: ");

        System.out.println(bD.DatosPersonas(dni));

    }

}
