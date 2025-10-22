package crudpoo;

public class Cliente extends Persona {
    
    int nroCliente;

    private static int contador = 1; 

    public Cliente(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.nroCliente = contador++;
    }

    @Override
    public String toString() {
        return super.toString() + " - NroCliente: " + nroCliente;
    }
}
