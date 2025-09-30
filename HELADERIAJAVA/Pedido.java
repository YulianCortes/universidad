import java.util.ArrayList;

public class Pedido {
    private ArrayList<Helado> listaHelados;
    private ArrayList<Malteada> listaMalteadas;
    public int mesa;
    public float propina;

    // Constructor
    public Pedido(int mesa) {
        this.mesa = mesa;
        this.listaHelados = new ArrayList<>();
        this.listaMalteadas = new ArrayList<>();
        this.propina = 0;
    }

    // Métodos
    public float calcularCuenta() {
        float total = 0;
        for (Helado helado : this.listaHelados) {
            total += helado.calcularPrecio();
        }
        for (Malteada malteada : this.listaMalteadas) {
            total += malteada.calcularPrecio();
        }
        return total + this.propina;
    }

    public void limpiarPedido() {
        this.listaHelados.clear();
        this.listaMalteadas.clear();
        this.propina = 0;
    }

    public boolean estaLibre() {
        return this.listaHelados.isEmpty() && this.listaMalteadas.isEmpty();
    }

    // Setters
    public void addHelado(Helado producto) {
        this.listaHelados.add(producto);
    }

    public void addMalteada(Malteada producto) {
        this.listaMalteadas.add(producto);
    }

    public void setPropina(float propina) {
        this.propina = propina;
    }

    // Getters
    public int getMesa() {
        return mesa;
    }

    public ArrayList<Helado> getListaHelados() {
        return listaHelados;
    }

    public ArrayList<Malteada> getListaMalteadas() {
        return listaMalteadas;
    }
}
