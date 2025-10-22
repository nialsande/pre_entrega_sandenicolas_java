package crudpoo;

public abstract class Persona {
    private int id;
    private int dni;
    private String nombre;
    private String apellido;

    private static int contador = 1; 

    public Persona(int dni, String nombre, String apellido) {
        this.id = contador++;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return apellido + ", " + nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return getNombre() + " - Dni: " + dni;
    }
}
