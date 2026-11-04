package arreglos.tienda.modelo;

public class Juego {
    private String nombre;
    private String catgeoria;
    private int tamanio;
    private double precio;
    private int licenciasDisponibles;
    private int licenciasVendidas;

    // Contructor
    public Juego(String nombre, String catgeoria, int tamanio, double precio, int licenciasDisponibles) {
        this.nombre = nombre;
        this.catgeoria = catgeoria;
        this.tamanio = tamanio;
        this.precio = precio;
        this.licenciasDisponibles = licenciasDisponibles;
        licenciasVendidas = 0;
    }

    // Get
    public String getNombre() {
        return nombre;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public String getCatgeoria() {
        return catgeoria;
    }

    //Set
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setCatgeoria(String catgeoria) {
        if (catgeoria != null && !catgeoria.trim().isEmpty()){
            this.catgeoria = catgeoria;
        }
    }

    public void setTamanio(int tamanio) {
        if (tamanio > 0){
            this.tamanio = tamanio;
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0){
            this.precio = precio;
        }
    }

    // Métodos
    public boolean comprar(int cantidad){
        if (cantidad > 0){
            licenciasDisponibles += cantidad;
            return true;
        }else{
            return false;
        }
    }

    public boolean vender(int cantidad){
        if (cantidad > 0 && cantidad <= licenciasDisponibles){
            licenciasDisponibles -= cantidad;
            licenciasVendidas += cantidad;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", catgeoria='" + catgeoria + '\'' +
                ", tamanio=" + tamanio +
                ", precio=" + precio +
                ", licenciasDisponibles=" + licenciasDisponibles +
                ", licenciasVendidas=" + licenciasVendidas +
                '}';
    }
}