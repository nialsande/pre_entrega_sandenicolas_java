package crudpoo;

import java.util.ArrayList;

public class CrudPedidos extends CrudConsola<Pedido> {

    private final ArrayList<Pedido> pedidos;
    private final ArrayList<Producto> productos;
    private final ArrayList<Persona> personas;

    public CrudPedidos(ArrayList<Pedido> pedidos, ArrayList<Producto> productos, ArrayList<Persona> personas) {
        this.pedidos = pedidos;
        this.productos = productos;
        this.personas = personas;
    }

    @Override
    public void crear() {
        if(productos.isEmpty()) {
            System.out.println("Primero debe crear un producto.");
            return;
        }
        
        if(!personas.isEmpty()) {
            boolean flagUsuario = false;
            boolean flagCliente = false;

            for (Persona p : personas) {
                if(!flagUsuario && p instanceof Usuario) {
                    flagUsuario = true;
                }

                if(!flagCliente && p instanceof Cliente) {
                    flagCliente = true;
                }

                if(flagUsuario && flagCliente) break;
            }

            if(!flagUsuario)
                System.out.println("Primero debe crear un vendedor.");
            if(!flagCliente)
                System.out.println("Primero debe crear un cliente.");
        } else {
            System.out.println("Primero debe crear una persona.");
            return;
        }


        System.out.println("Vendedores:");
        for(Persona p : personas) {
            if(p instanceof Usuario){
                System.out.println(p.getId() + ") " + p.getNombre());
            }            
        }
        int idUsuario = leerEntero("Elegí id de vendedor: ");
        Usuario usuarioSelec = null;
        for (Persona p : personas) {
            if (p instanceof Usuario && p.getId() == idUsuario) { usuarioSelec = ((Usuario)p); break; }
        }

        System.out.println("Clientes:");
        for(Persona p : personas) {
            if(p instanceof Cliente){
                System.out.println(p.getId() + ") " + p.getNombre());
            }            
        }
        int idCliente = leerEntero("Elegí id de vendedor: ");
        Cliente clienteSelec = null;
        for (Persona p : personas) {
            if (p instanceof Cliente && p.getId() == idCliente) { clienteSelec = ((Cliente)p); break; }
        }

        boolean continuarPedido = true;
        ArrayList<Producto> carrito = new ArrayList<Producto>();
        do {
            System.out.println("Productos:");
            for (Producto p : productos) {
                System.out.println(p.getId() + ") " + p.getNombre());
            }
            int idProducto = leerEntero("Elegí id de vendedor: ");
            Producto productoSelec = null;
            for (Producto p : productos) {
                if (p.getId() == idProducto) { 
                    productoSelec = p; 
                    carrito.add(productoSelec);
                    break;
                }
            }
            if(productoSelec == null) {
                System.out.println("Producto inválido.");
            }

            int cont = leerEntero("Agregar mas productos?: (1) Si | (0) No (Si elige otro numero se tomara como NO)");
            if(cont != 1)
                continuarPedido = false;
        } while (continuarPedido);

        if(usuarioSelec == null) {
            System.out.println("Vendedor inválido.");
        } else if(clienteSelec == null) {
            System.out.println("Cliente inválido.");
        } else if(carrito.size() > 0) {
            System.out.println("Carrito inválido.");
        } else {
            pedidos.add(new Pedido(usuarioSelec, clienteSelec, carrito));
            System.out.println("Pedido creado.");
        }
    }

    @Override
    public void listar() {
        if (pedidos.isEmpty()) {
            System.out.println("(sin pedidos)");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p.toString());
            }
        }
    }

    @Override
    public void actualizar() {
        int nroPedido = leerEntero("Id del Pedido: ");
        for (Pedido p : pedidos) {
            if (p.getNroPedido() == nroPedido) {

                System.out.println("Vendedores:");
                for(Persona pers : personas) {
                    if(pers instanceof Usuario){
                        System.out.println(pers.getId() + ") " + pers.getNombre());
                    }            
                }
                int idUsuario = leerEntero("Elegí id de vendedor: ");
                Usuario usuarioSelec = null;
                for (Persona pers : personas) {
                    if (pers instanceof Usuario && pers.getId() == idUsuario) { usuarioSelec = ((Usuario)pers); break; }
                }
                if(usuarioSelec == null) {
                    System.out.println("Vendedor inválido.");
                    return;
                } else {
                    p.setVendedor(usuarioSelec);
                }

                System.out.println("Clientes:");
                for(Persona pers : personas) {
                    if(pers instanceof Cliente){
                        System.out.println(pers.getId() + ") " + pers.getNombre());
                    }            
                }
                int idCliente = leerEntero("Elegí id de cliente: ");
                Cliente clienteSelec = null;
                for (Persona pers : personas) {
                    if (pers instanceof Cliente && pers.getId() == idCliente) { clienteSelec = ((Cliente)pers); break; }
                }
                if(clienteSelec == null) {
                    System.out.println("Cliente inválido.");
                    return;
                } else {
                    p.setCliente(clienteSelec);
                }

                System.out.println("\n1) Agregar Producto");
                System.out.println("2) Quitar Producto");
                System.out.println("0) Dejar asi");
                int op = leerEntero(("Elegi una opcion: "));

                if (op == 1) {
                    boolean continuarPedido = true;
                    do {
                        System.out.println("Productos:");
                        for (Producto prod : productos) {
                            System.out.println(prod.getId() + ") " + prod.getNombre());
                        }
                        int idProducto = leerEntero("Elegí id de vendedor: ");
                        Producto productoSelec = null;
                        for (Producto prod : productos) {
                            if (prod.getId() == idProducto) { 
                                productoSelec = prod; 
                                p.addProducto(productoSelec);
                                break;
                            }
                        }
                        if(productoSelec == null) {
                            System.out.println("Producto inválido.");
                        }

                        int cont = leerEntero("Agregar mas productos?: (1) Si | (0) No (Si elige otro numero se tomara como NO)");
                        if(cont != 1)
                            continuarPedido = false;
                    } while (continuarPedido);

                } else if (op == 2) {
                    System.out.println("Productos:");
                    int cant = 1;
                    for(String prod : p.getProductos()) {
                            System.out.println(cant + ") " + prod);
                        cant++;
                    }
                    int eleccion = leerEntero("Elegí un producto a eliminar: ");
                    if(eleccion > cant || eleccion < 0) {
                        System.out.println("Opción inválida.");
                    } else {
                        p.removeProducto(eleccion - 1);
                    }
                    
                } else if (op == 0) {

                } else {
                    System.out.println("Opción inválida.");
                }

                System.out.println("Actualizado: " + p.toString());
                return;
            }
        }
        System.out.println("No se encontró Pedido con Nro Pedido: " + nroPedido);
    }

    @Override
    public void eliminar() {
        int nroPedido = leerEntero("Nro de Pedido a eliminar: ");
        boolean eliminado = pedidos.removeIf(p -> p.getNroPedido() == nroPedido);
        System.out.println(eliminado ? "Pedido eliminado." : "No se encontró Pedido con Nro: " + nroPedido);
    }
    
}
