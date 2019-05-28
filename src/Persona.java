
public class Persona {

    private String dni;
    private String nombre;
    private String apellidos;
    private int telefono;
    private int edad;
    private double peso;

    public Persona(String dni, String nombre, String apellidos, int telefono, int edad, double peso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.edad = edad;
        this.peso = peso;
    }

    public Persona() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", edad=" + edad + ", peso=" + peso + '}';
    }

}
