package domain;

import java.util.ArrayList;
import java.util.Arrays;



public class Limpieza extends Producto {
    private static final String ALFA_CODE_LIMPIEZA = "AZ";
    private static int cantidadRegistrada = 0;
    private String tipoDeAplicacion;
    private ArrayList<String> opciones_De_Apliacion = new ArrayList<>(Arrays.asList("COCINA", "BANIO", "ROPA", "MULTIUSO"));


    public Limpieza(String descripcion, int stock, float precio, float ganaciaPorcentual, boolean disponibilidad, String tipoDeAplicacion) {
        super(generarCodigo(ALFA_CODE_LIMPIEZA, cantidadRegistrada), descripcion, stock, precio, ganaciaPorcentual, disponibilidad);
        this.tipoDeAplicacion = verificarTipoDeUso(tipoDeAplicacion);
    }

    private String verificarTipoDeUso(String tipoDeUso) {
        String tipoMAYUS = tipoDeUso.toUpperCase();
        if (opciones_De_Apliacion.contains(tipoMAYUS)) {
            return tipoMAYUS;
        } else
            return "Error";


    }

    @Override
    public void mostrarInfoProducto() {
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Sirve para: : " + tipoDeAplicacion);
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());


    }
}
