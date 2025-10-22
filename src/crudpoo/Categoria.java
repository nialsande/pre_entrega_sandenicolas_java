package crudpoo;

import java.util.ArrayList;

public class Categoria {
    
    private int id;
    private String nombre;

    private static int contador = 1; 

    public Categoria(String nombre) {
        this.id = contador++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{id= " + id + ", nombre: '" + nombre + "'}";
    }

    public int getIdPorNombre(ArrayList<Categoria> categorias, String nombre) {
        for (Categoria c : categorias) {
            if(c.getNombre() == nombre)
                return c.getId();
        }
        return -1;
    }
}
