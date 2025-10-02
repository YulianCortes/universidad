package HELADERIA;
import java.util.ArrayList;
 
public class Heladeria {
    public int id;
    private String direccion;
    private ArrayList<Helado> listaHeladosDisponibles;
    private ArrayList<Malteada> listaMalteadasDisponibles;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Toppings> listaToppings;
    // Constructor de clase
    public Heladeria(int id, String direccion){
        this.id = id;
        this.direccion = direccion;
        this.listaHeladosDisponibles = new ArrayList<Helado>();
        this.listaMalteadasDisponibles = new ArrayList<Malteada>();
        this.listaPedidos = new ArrayList<Pedido>();
        this.listaToppings = new ArrayList<Toppings>();
    }
    // Metodos de clase
    // setters
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setListaHeladosDisponibles(ArrayList<Helado> lista){
        this.listaHeladosDisponibles = lista;
    }
    public void setListaMalteadasDisponibles(ArrayList<Malteada> lista){
        this.listaMalteadasDisponibles = lista;
    }
    public void setListaToppings(ArrayList<Toppings> lista){
        this.listaToppings = lista;
    }
 
    public void addListaPedidos(Pedido pedido){
        this.listaPedidos.add(pedido);
    }
    // getters
    public String getDireccion(){
        return this.direccion;
    }
    public ArrayList<Helado> getListaHeladosDisponibles(){
        return this.listaHeladosDisponibles;
    }
    public ArrayList<Malteada> getListaMalteadasDisponibles(){
        return this.listaMalteadasDisponibles;
    }
    public ArrayList<Pedido> getListaPedidos(){
        return this.listaPedidos;
    }
    public ArrayList<Toppings> getListaToppings(){
        return this.listaToppings;
    }
 
 
 
 
 
}
 