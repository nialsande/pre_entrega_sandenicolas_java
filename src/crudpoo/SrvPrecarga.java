package crudpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class SrvPrecarga {

    protected final Scanner scanner = new Scanner(System.in);

    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;

    public SrvPrecarga(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    public void cargar() {
        System.out.println("\n =Carga rapida de datos para prueba=");
        System.out.println("==== Menu Precarga ===");
        System.out.println("Desea cargar datos? 1) Si | 0) NO/Volver");
        int op = leerEntero(("Elegi una opcion: "));
    
        if(op == 1) {
            categorias.add(new Categoria("Tecnología"));
            categorias.add(new Categoria("Hogar"));
            categorias.add(new Categoria("Libros"));
            productos.add(new Articulo("Tecnología", 1000, categorias.get(0)));
            productos.add(new Articulo("Hogar", 100, categorias.get(2)));
            productos.add(new Articulo("Libros", 500, categorias.get(1)));
            System.out.println("Carga completa.");
        } else if (op == 0) {
            System.out.println("Volviendo al menú principal...");
        } else {
            System.out.println("Opcion invalida.");
        }
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
}
