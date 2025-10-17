package crudpoo;

import java.util.Scanner;

public abstract class CrudConsola<T> {
    protected final Scanner scanner = new Scanner(System.in);

    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();

    public void mostrarOpciones() {
        System.out.println("\n === Menu Crud ===");
        System.out.println("1) Crear");
        System.out.println("2) Listar");
        System.out.println("3) Actualizar");
        System.out.println("4) Eliminar");
        System.out.println("0) Volver/Salir");
        System.out.print("Opcion elegida: ");
    }

    protected int leerEntero(String msj){
        while (true) {
            try {
                System.out.print(msj);
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    protected double leerDouble (String msj) {
        while (true) {
            try {
                System.out.print(msj);
                String linea = scanner.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero (utilice el punto(.) para la coma).");
            }
        }
    }

    protected String leerTexto(String msj) {
        //Se podria validar que no sea un string vacio ??
        System.out.print(msj);
        return scanner.nextLine();
    }
}
