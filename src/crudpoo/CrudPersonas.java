package crudpoo;

import java.util.ArrayList;

public class CrudPersonas extends CrudConsola<Persona> {

    private final ArrayList<Persona> personas;

    public CrudPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public void crear() {
        
        System.out.println("\n === Menu Persona ===");
        System.out.println("(1) Crear Usuario");
        System.out.println("(2) Crear Cliente");
        int op = leerEntero(("Elegi una opcion: "));


        if(op == 1) {
            String nombre = leerTexto("Nombre: ");
            String apellido = leerTexto("Apellido: ");
            int dni = leerEntero("Dni: ");
            String correo = leerTexto("Correo: ");

            personas.add(new Usuario(dni, nombre, apellido, correo));
            System.out.println("Usuario creado.");

        } else if (op == 2) {
            String nombre = leerTexto("Nombre: ");
            String apellido = leerTexto("Apellido: ");
            int dni = leerEntero("Dni: ");

            personas.add(new Cliente(dni, nombre, apellido));
            System.out.println("Usuario creado.");

        } else {
            System.out.println("Opción inválida.");
        }
    }

    @Override
    public void listar() {
        if (personas.isEmpty()) {
            System.out.println("(sin personas)");
        } else {
            for (Persona p : personas) {
                System.out.println(p);
            }
        }
    }

    @Override
    public void actualizar() {
        int id = leerEntero("Id de la persona: ");
        for (Persona p : personas) {
            if (p.getId() == id) {

                String nombreNuevo = leerTexto("Nombre: ");
                String apellidoNuevo = leerTexto("Apellido: ");
                int dniNuevo = leerEntero("Dni: ");
                p.setNombre(nombreNuevo);
                p.setApellido(apellidoNuevo);
                p.setDni(dniNuevo);
                
                if (p instanceof Usuario) {

                    String correoNuevo = leerTexto("Correo: ");
                    ((Usuario)p).setCorreo(correoNuevo);
                }

                System.out.println("Actualizado: " + p.toString());
                return;
            }
        }
        System.out.println("No se encontró persona con id: " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la persona a eliminar: ");
        boolean eliminado = personas.removeIf(p -> p.getId() == id);
        System.out.println(eliminado ? "Persona eliminada." : "No se encontró persona con id: " + id);
    }
}
