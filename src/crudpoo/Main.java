package crudpoo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){


        final ArrayList<Producto> productos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();
        final ArrayList<Persona> personas = new ArrayList<>();
        final ArrayList<Pedido> pedidos = new ArrayList<>();

        final CrudProductos crudProd = new CrudProductos(productos, categorias);
        final CrudCategorias crudCat = new CrudCategorias(categorias);
        final CrudPersonas crudPers = new CrudPersonas(personas);
        final CrudPedidos crudPedid = new CrudPedidos(pedidos, productos, personas);
        final SrvPrecarga srvPrecarga = new SrvPrecarga(productos, categorias, personas, pedidos);

        int opcion;

        do {
            System.out.println("\n ==== Menu ===");
            System.out.println("(1) CRUD Productos");
            System.out.println("(2) CRUD de Categorías");
            System.out.println("(3) CRUD de Personas");
            System.out.println("(4) CRUD de Pedidos");
            System.out.println("(9) Precargar datos");
            System.out.println("(0) Salir");

            System.out.print("Opcion elegida: ");
            String linea = crudProd.scanner.nextLine();

            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        crudProd.mostrarOpciones();
                        op = crudProd.leerEntero("");
                        switch (op) {
                            case 1 -> crudProd.crear();
                            case 2 -> crudProd.listar();
                            case 3 -> crudProd.actualizar();
                            case 4 -> crudProd.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones();
                        op = crudCat.leerEntero("");
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.actualizar();
                            case 4 -> crudCat.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 3 -> {
                    int op;
                    do {
                        crudPers.mostrarOpciones();
                        op = crudPers.leerEntero("");
                        switch (op) {
                            case 1 -> crudPers.crear();
                            case 2 -> crudPers.listar();
                            case 3 -> crudPers.actualizar();
                            case 4 -> crudPers.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 4 -> {
                    int op;
                    do {
                        crudPedid.mostrarOpciones();
                        op = crudPedid.leerEntero("");
                        switch (op) {
                            case 1 -> crudPedid.crear();
                            case 2 -> crudPedid.listar();
                            case 3 -> crudPedid.actualizar();
                            case 4 -> crudPedid.eliminar();
                            case 0 -> System.out.println("Volviendo al menú principal...");
                            default -> System.out.println("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 9 -> {
                    
                    srvPrecarga.cargar();
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        }while (opcion != 0);
    }
}
