package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    // Constructor
    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    // Get
    public Juego[] getJuegos() {
        return juegos;
    }

    // Set
    public void setJuegos(Juego juegos[]) {
        this.juegos = juegos;
    }

    public boolean agrearJuego(Juego j){
        if(j!=null && indice < MAX-1){
            juegos[++indice] = j;
            return true;
        }else{
            return false;
        }
    }

    public Juego buscarJuego(String nombre){
        for (int i = 0; i < indice; i++){
            if (juegos[i].getNombre().equalsIgnoreCase(nombre)){
                return juegos[i];
            }
        }
        return null;
    }

    public boolean comprar (String nombre, int cantidad) {
        if (nombre != null && !nombre.trim().isEmpty() && cantidad > 0) {
            Juego j = buscarJuego(nombre);
            if (j != null) {
                return j.comprar(cantidad):
            }
        }
        return false;
    }
}