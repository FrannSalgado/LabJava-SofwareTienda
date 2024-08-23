package domain;

import java.util.ArrayList;
import java.util.Arrays;



public class Limpieza extends Producto {
    private static final String ALFA_CODE_LIMPIEZA = "AZ";
    private static int cantidadRegistrada = 0;
    private String tipoDeAplicacion;
    private ArrayList<String> opciones_De_Apliacion = new ArrayList<>(Arrays.asList("COCINA", "BANIO", "ROPA", "MULTIUSO"));


    public Limpieza(String descripcion, int stock, float precio, float ganaciaPorcentual, boolean disponibilidad, String tipoDeAplicacion,boolean esImportado, float descuento ) {
        super(generarCodigo(ALFA_CODE_LIMPIEZA, cantidadRegistrada), descripcion, stock, precio, ganaciaPorcentual, disponibilidad, esImportado,descuento);
        this.tipoDeAplicacion = verificarTipoDeUso(tipoDeAplicacion);
        if (gananciaPorcentual > 25) {
            throw new IllegalArgumentException("La ganancia en productos de Limpieza no puede superar el 25%");
        } else if (gananciaPorcentual <= 10 && (this.tipoDeAplicacion.toUpperCase()!="COCINA") && this.tipoDeAplicacion.toUpperCase() != "MULTIUSO") {
            throw new IllegalArgumentException("La ganancia en productos de Limpieza no puede ser menor al 10%, excepto para productos de tipo COCINA y MULTIUSO");
        }
        if(descuento >20 ){
            throw new IllegalArgumentException("El descuento No puede ser Mayor a 20%");
        }

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
        System.out.println("----------------------------|----------------------------");
        System.out.println("ID: " + identificadorAlfNum);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Sirve para: : " + tipoDeAplicacion);
        System.out.println("Cantidad en stock: " + sotck);
        System.out.println("Precio por unidad: $" + precio);
        System.out.println("Porcentaje de ganancia: " + gananciaPorcentual + "%");
        System.out.println("Disponible para venta: " + (disponibilidad ? "Sí" : "No"));
        System.out.println("Precio de venta: $" + calcularPrecioVenta());
        System.out.println("Descuento: " + descuento +"%" );
        System.out.println("----------------------------|----------------------------");


    }
}
