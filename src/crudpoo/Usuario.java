package crudpoo;

public class Usuario extends Persona {
    
    private String correo;

    public Usuario(int dni, String nombre, String apellido, String correo) { 
        super(dni, nombre, apellido);
        this.correo = correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return super.toString() + " - Correo: " + (correo != null ? correo : "Sin correo");
    }
}
