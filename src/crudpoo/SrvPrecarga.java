package crudpoo;

import java.util.ArrayList;
import java.util.Scanner;

public class SrvPrecarga {

    protected final Scanner scanner = new Scanner(System.in);

    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;
    private final ArrayList<Persona> personas;
    private final ArrayList<Pedido> pedidos;

    public SrvPrecarga(ArrayList<Producto> productos, ArrayList<Categoria> categorias, ArrayList<Persona> personas, ArrayList<Pedido> pedidos) {
        this.productos = productos;
        this.categorias = categorias;
        this.personas = personas;
        this.pedidos = pedidos;
    }

    public void cargar() {
        System.out.println("\n =Carga rapida de datos para prueba=");
        System.out.println("==== Menu Precarga ===");
        System.out.println("Desea cargar datos?");
        System.out.println("(1) Si | (0) NO/Volver");
        int op = leerEntero(("Elegi una opcion: "));
    
        if(op == 1) {
            categorias.add(new Categoria("Tecnología"));
            categorias.add(new Categoria("Hogar"));
            categorias.add(new Categoria("Bazar"));

            int indexCat = 0;
            int count = 0; 
            for (Categoria cat : categorias) {
                if(cat.getNombre() == "Bazar") {
                    indexCat = count;
                }
                count++;
            }
            
            productos.add(new Articulo("Plato", 1000, categorias.get(indexCat)));
            productos.add(new Articulo("Vaso", 500, categorias.get(indexCat)));
            productos.add(new Articulo("Cuchara", 100, categorias.get(indexCat)));

            int indexProd = 0;
            count = 0;
            for (Producto prod : productos) {
                if(prod.getNombre() == "Plato") {
                    indexProd = count;
                    break;
                }
                count++;
            }

            personas.add(new Usuario(123456789, "Bruno", "ElGato", "bruno@elgato.com"));
            personas.add(new Usuario(123456788, "Tony", "ElGris", "toni@elgris.com"));
            personas.add(new Cliente(123456787, "Tuco", "LaGata"));
            personas.add(new Cliente(123456786, "Momo", "ElNegro"));

            int indexUsu = 0;
            int indexCli = 0;
            count = 0;
            for (Persona pers : personas) {
                if(pers.getDni() == 123456789) {
                    indexUsu = count;
                }
                else if (pers.getDni() == 123456786) {
                    indexCli = count;
                }
                count++;
            }
            ArrayList<Producto> carrito = new ArrayList<Producto>();
            carrito.add(productos.get(indexProd));

            pedidos.add(new Pedido((Usuario)(personas.get(indexUsu)), ((Cliente)personas.get(indexCli)), carrito));

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
