
package HELADERIA;
import java.util.ArrayList;
 
 
public class Main {
    ArrayList<Heladeria> listaHeladerias = new ArrayList<Heladeria>();
    ArrayList<Helado> listaHelados = new ArrayList<Helado>();
    ArrayList<Malteada> listaMalteadas = new ArrayList<Malteada>();
    ArrayList<Toppings> listaToppings = new ArrayList<Toppings>();
 
    public static void main(String[] args) {
        
    }
    public void crud(String titulo, int idTipoRecurso){
        if(idTipoRecurso == 1){
            ArrayList <Heladeria> recurso = this.listaHeladerias;
        }
        if(idTipoRecurso == 2){
            ArrayList <Helado> recurso = this.listaHelados;
        }
        
        if(idTipoRecurso == 3){
            ArrayList <Malteada> recurso = this.listaMalteadas;
        }
        if(idTipoRecurso == 4){
            ArrayList <Toppings> recurso = this.listaToppings;
        }
        System.out.println(titulo);
        Menus menuCrud = new Menus(40, '-', '1');
        ArrayList<String> options = new ArrayList<String>();
        options.add("Crear");
        options.add("Ver");
        options.add("Editar");
        options.add("Eliminar");
        options.add("Volver");
        menuCrud.createMenu(options, false);   
 
    }
}
 