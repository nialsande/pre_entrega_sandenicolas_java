package crudpoo;

import java.util.ArrayList;

public class Pedido {
    private int nroPedido;
    private Usuario vendedor;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    private static int contador = 1;

    public Pedido(Usuario vendedor, Cliente cliente, ArrayList<Producto> productos){
        this.nroPedido = contador++;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.productos = productos;
    }

    public int getNroPedido() {
        return nroPedido;
    }

    public String getVendedor() {
        return vendedor.toString();
    }

    public String getCliente() {
        return cliente.toString();
    }

    public ArrayList<String> getProductos() {
        ArrayList<String> retorno = new ArrayList<String>();

        for (Producto producto : productos) {
            retorno.add(producto.toString());
        }

        return retorno;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void removeProducto(int index) {
        if(this.productos.size() > 0) {
            productos.remove(1);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No hay productos.");
        }
    }

    @Override
    public String toString() {
        return "Pedido Nro: " + nroPedido 
            + " - Vendedor: " + vendedor.getNombre() 
            + " - Cliente: " + cliente.getNombre()
            + " - Cantidad de Productos: " + productos.size();
    }
}
