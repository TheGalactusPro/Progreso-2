package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;
import arreglos.tienda.utilitario.Valida;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        int opc2 = 0;
        tienda.cargarDatos();
        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{
                    ingresarJuegos();
                }break;

                case 2:{
                    mostrarJuegos();
                }break;

                case 3:{
                    buscarJuego();
                }break;

                case 4:{
                    comprarJuego();
                }break;

                case 5:{
                    venderJuego();
                }break;

                case 6:{
                    juegoMasVendido();
                }break;

                case 7:{
                    System.out.println("Gracias por usar nuestros servicios");
                }break;

                default:
                    System.out.println("Opción no válida");
            }

            // Ayuda de la IA

            if (opc != 7){
                System.out.println("\n¿Desea continuar?");
                System.out.println("1. Sí");
                System.out.println("2. No");
                System.out.print("Seleccione una opción: ");

                opc2 = Integer.parseInt(sc.nextLine());

                if (opc2 == 2){
                    opc = 7;
                    System.out.println("Gracias por usar nuestros servicios");
                }
            }

        }while(opc != 7);
    }

    public static void menu(){
        System.out.println("--------------------AppStore Udla--------------------");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuegos(){
        System.out.println("INGRESO DE DATOS");

        String nombre = Valida.leerString("Ingrese el nombre");

        String categoria = Valida.leerString("Ingresa la categoría");

        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());

        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());

        if (tienda.agrearJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null,"El juego se ha agregado con éxito!!");
        }else{
            JOptionPane.showMessageDialog(null,"El juego no pudo ser agregado");
        }
}

    public static void mostrarJuegos(){
        Juego juegos[] = tienda.getJuegos();

        if (tienda.getIndice() >= 0){
            for (int i = 0; i <= tienda.getIndice(); i++){
                System.out.println(juegos[i]);
            }
        }else{
            System.out.println("No existe juegos a mostrar");
        }
    }

    public static void buscarJuego(){
        String nombre = Valida.leerString("Ingrese el nombre del juego");

        Juego j = tienda.buscarJuego(nombre);

        if (j != null){
            System.out.println("Juego encontrado:");
            System.out.println(j);
        }else{
            System.out.println("El juego no existe");
        }
    }

    public static void comprarJuego(){
        String nombre = Valida.leerString("Ingrese el nombre del juego");

        Juego j = tienda.buscarJuego(nombre);

        if (j != null){
            System.out.print("Ingrese la cantidad a comprar: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            if (tienda.comprar(nombre, cantidad)){
                JOptionPane.showMessageDialog(null,"Compra realizada con éxito");
            }else{
                JOptionPane.showMessageDialog(null,"Cantidad no válida");
            }
        }
    }

    public static void venderJuego() {
        String nombre = Valida.leerString("Ingrese el nombre del juego");

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        double total = tienda.vender(nombre, cantidad);

        if (total > 0) {
            JOptionPane.showMessageDialog(null,
                    "Venta realizada con éxito\nTotal: $" + total);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se pudo realizar la venta");
        }
    }

    public static void juegoMasVendido(){
        if (tienda.getIndice() >= 0){
            String nombre = tienda.masVendido();

            if (!nombre.isEmpty()){
                System.out.println("JUEGO MÁS VENDIDO: " + nombre);
            }else{
                System.out.println("No hay juegos vendidos todavía");
            }
        }
    }
}

// Todos los métodos deben ser estaticos